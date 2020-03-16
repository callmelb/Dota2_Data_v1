from dota2_api_tools.get_matchData import *
from pyecharts import Line

def get_png(match_id,duration,path):
    gold =get_match_gold_xp_gap(match_id)[0]
    xp = get_match_gold_xp_gap(match_id)[1]

    print(len(gold))
    print(len(xp))

    attr = []
    for m in range(1,len(gold)+1):
        attr.append(m)
    print(attr)
    line = Line("经济经验差异曲线")
    line.add("经济差异曲线", attr, gold,is_smooth=True,mark_line=["max", "min"])
    line.add("经验差异曲线", attr, xp,is_smooth=True)
    #line.show_config()
    line.render(path="{}".format(path))
