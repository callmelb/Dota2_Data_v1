from dota2_api_tools.get_api_json import *

#获取单场比赛整体数据  参数:比赛id   返回值:比赛数据json
def get_matchData(match_id):
    matchData = get_api_json('https://api.opendota.com/api/matches/{}'.format(match_id))
    return matchData

#获取比赛胜利阵营   参数:比赛id    返回值:胜利方名字    "1":Radiant天辉  "0":'Dire'夜宴方
def get_match_win(match_id):
    match_win_Data = get_matchData(match_id)['radiant_win']
    match_win = 1 if match_win_Data is True else '0'
    return match_win

#获取比赛英雄阵容   参数:比赛id    返回值:带有两个list的tuple   ([天辉],[夜宴])
def get_match_heroids(match_id):
    heroids_data = get_matchData(match_id)['picks_bans']
    Radiant_list = []
    Dire_list = []
    for hd in range(len(heroids_data)):
        if heroids_data[hd]['is_pick'] is True:
            if heroids_data[hd]['team'] == 1:
             Radiant_list.append(heroids_data[hd]['hero_id'])
            if heroids_data[hd]['team'] == 0:
             Dire_list.append(heroids_data[hd]['hero_id'])


    return Radiant_list , Dire_list

#获取比赛经济、经验差距 制作曲线   参数:比赛id
def get_match_gold_xp_gap(match_id):
    goldList = get_matchData(match_id)['radiant_gold_adv']
    xpList = get_matchData(match_id)['radiant_xp_adv']
    return goldList,xpList


if __name__ == '__main__':
    pass



#print(get_match_gold_xp_gap(4790160809))
#print(type(get_match_gold_xp_gap(4790160809)))
