from dota2_api_tools.get_matchData import *
from dota2_api_tools.get_png import *
from selenium import webdriver
import time
import os
'''
文字需要的数据:
1.比赛从属系列    √
2.比赛id          √
3.比赛双方战队    √
4.人头比           √
5.获胜战队          √

图片需要的数据:
1.比赛从属系列        √
2.比赛双方战队        √
3.比赛双方战队对标logo(图片)
4.人头比              √
5.获胜战队
6.比赛经济曲线(可附加经验，获胜概率)
7.在曲线上可加特定点

进阶图片（装备线路图）
'''
def matchReport(match_id):
    #5282227612
    #match_id = 5212816885
    if os.path.exists('f:/testdata/data/{}'.format(match_id)) is False:
        matchData = get_matchData(match_id)
        league_name = matchData['league']['name']
        radiant_team = matchData['radiant_team']['tag']
        dire_team = matchData['dire_team']['tag']
        duration = int(matchData['duration']/60)
        radiant_total_kills = matchData['radiant_score']
        dire_total_kills = matchData['dire_score']
        win_temp = radiant_team if matchData['radiant_win'] is True \
                                    else dire_team
        hero = get_match_heroids(match_id)
        radiant_heroids = str(hero[1]).strip("[").strip("]")
        dire_heroids = str(hero[0]).strip("[").strip("]")
        print(hero)
        print(radiant_heroids)
        print(league_name)
        print(radiant_team)
        print(dire_team)
        print(radiant_total_kills)
        print(dire_total_kills)
        print(win_temp)

        p_json = '"league_name":"{}","'.format(league_name)+\
                 'radiant_team":"{}","'.format(radiant_team)+\
                 'dire_team":"{}","'.format(dire_team)+\
                 'win_team":"{}","'.format(win_temp)+\
                 'radiant_heroids":"{}","'.format(radiant_heroids)+\
                 'dire_heroids":"{}","'.format(dire_heroids)+\
                 'duration":{},"'.format(duration)+\
                 'r_score":{},"'.format(radiant_total_kills)+\
                 'd_score":{}'.format(dire_total_kills)
        print(p_json)

        #os.rmdir('f:/testdata/{}'.format(match_id))
        os.makedirs('f:/testdata/data/{}'.format(match_id))
        with open('f:/testdata/data/{}/{}.json'.format(match_id,match_id),'a+') as f:
            f.write("{"+p_json+"}")

        print(r'「#{}#」'.format(league_name),' ',\
              radiant_team,'对阵',dire_team,'\n',\
              '本场耗时{}分钟    人头比{}:{}    '.format(duration,radiant_total_kills,dire_total_kills),\
              '{}获胜'.format(win_temp),\
              '\n''\n''ps.本场比赛id:{}。本条动态由python自动发出，并感谢lb的独家赞助'.format(match_id))
        get_png(match_id,duration,'f:/testdata/data/{}/{}.png'.format(match_id,match_id))
    else:
        pass
matchReport(5289041688)




