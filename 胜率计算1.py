from datetime import datetime

from dota2_api import get_api_json
import time
#start=time.process_time()

#判断比赛胜负的方法 True为天辉胜利   False则为夜宴胜利
def win_or_defeat(match_id):
    match_info = get_api_json('https://api.opendota.com/api/matches/{}'.format(match_id))
    if match_info['radiant_win'] == True:
        return True
    else:
        return False

#判断战队在哪一阵营
def team_win_or_defeat(match_id):
    match_info = get_api_json('https://api.opendota.com/api/matches/{}'.format(match_id))
    if match_info['radiant_team_id'] == 1838315:  #判断秘密战队是否为天辉方,
                                                  #注意千万不要带上引号啊！！！
        return True
    else:
        return False

'''       if match_info['radiant_win'] == True:
            return True         #此结果为秘密战队获胜
    else:
        if match_info['radiant_win'] == False:
            return True
'''
#批量获取比赛id
sql = """SELECT match_id
FROM matches
join match_patch using(match_id)
JOIN leagues using(leagueid)
JOIN player_matches using(match_id)
where patch >= '7.24' 
AND (player_matches.account_id = 87278757)
AND (matches.leagueid = 10946)
ORDER BY match_id
LIMIT 60"""

# sql = """SELECT
# matches.match_id
# FROM matches
# JOIN match_patch using(match_id)
# JOIN leagues using(leagueid)
# where patch >= '7.24'
# ORDER BY RANDOM()
# LIMIT 100
# """

match_ids = get_api_json('https://api.opendota.com/api/explorer?sql={}'.format(sql))['rows']


matchCount = 0
winCount = 0
secret_winCount = 0
secret_rad = 0
for mi in match_ids:
    matchCount = matchCount + 1
    id = mi['match_id']
    if win_or_defeat(id) == True:
        winCount = winCount + 1
        if team_win_or_defeat(id) == True:
            print('天辉',id)
            secret_rad = secret_rad + 1
            secret_winCount = secret_winCount + 1
    else:
        if team_win_or_defeat(id) == False:
            print('夜宴',id)
            secret_winCount = secret_winCount + 1
winrate = round(winCount/matchCount,3)*100
print("比赛场数:",matchCount)
print("天辉获胜场数:",winCount)
print("天辉胜率:",winrate,"%")
print('-------------------------')
print("秘密战队获胜场数:",secret_winCount)
print("秘密战队胜率:",round(secret_winCount/matchCount,3)*100,"%")
print("秘密战队天辉胜率:",round(secret_rad/12,3)*100,"%")
'''
end=time.process_time()
ti = end-start
print(ti)
print("final is in ",datetime.timedelta(seconds=ti))
'''
