from dota2_api_tools.get_matchData import *
import matplotlib.pyplot as plt
from matplotlib.pyplot import MultipleLocator
import matplotlib.ticker as mticker
def get_png_v2(match_id):
    #根据比赛id获取比赛的经济差异，返回值是一个tuple
    gold_xp = get_match_gold_xp_gap(match_id)

    #根据返回来的tuple，确定经济，并创建对应list,0为经济，1为经验
    gold = gold_xp[0]

    #计算时间线(图像X轴):根据经济列表，得出比赛进行时间
    duration = [0]
    [duration.append('{}'.format(d)) for d in range(1,len(gold))]

    #配置主图表
    plt.rcParams['font.sans-serif'] = ['KaiTi']     #添加中文字体
    plt.rcParams['axes.unicode_minus']=False
    plt.title("比赛编号:「{}」".format(match_id),fontsize=18,verticalalignment='center')   #图表标题

    #设置一个算法，好处理坐标轴范围及间距
    betw = 2000 if max(gold) - min(gold) < 15000 else 5000

    plt.xlim(0,len(gold)+3)                           #设置x轴范围
    plt.ylim(min(gold)-betw,max(gold)+betw)         #设置y轴范围

    #设置x轴,y轴的间距刻度设置
    ax =plt.gca()                                       #创建子图
    ax.xaxis.set_major_locator(MultipleLocator(5))      #设置x轴间距为5
    ax.yaxis.set_major_locator(MultipleLocator(betw))   #y轴间距为一个变量

    ''' 待完成 将10000转换为10K'''
    ax.yaxis.set_major_formatter(mticker.FormatStrFormatter(r'%d'))
    ax.xaxis.set_major_formatter(mticker.FormatStrFormatter(r'%d:00'))
    #去除上边框和右边框
    ax.spines['top'].set_visible(False)
    ax.spines['right'].set_visible(False)
    ax.spines['left'].set_visible(False)
    ax.spines['bottom'].set_visible(False)
    #配置背景虚线框
    plt.grid(alpha=0.6)
    #加载经济曲线


    #plt.plot(list(duration[xi]),list(gold[xi]),color='#99aa40')
    #plt.plot(list(duration[xi]),list(gold[xi]),color='#c63836')

    plt.plot(duration,gold)

    #在经济曲线上增加10分钟经济领先标识

    if gold[10] > 0 :
        r10 = '十分钟经济 \n 领先{}'.format(gold[10])
        plt.annotate(r10,xy=(10,gold[10]),xytext=(10,(gold[10]+1.5*betw)),color='#99aa40',fontsize=14,weight='black',arrowprops=dict(facecolor='#99aa40',ec='#99aa40', shrink=1, width=2,\
                                                                              headwidth=2,headlength=2))
    else:
        d10 = '十分钟经济 \n 领先{}'.format(-gold[10])
        plt.annotate(d10,xy=(10,gold[10]),xytext=(10,(gold[10]-1.5*betw)),color='#c63836',fontsize=14,weight='black',arrowprops=dict(facecolor='#c63836',ec='#c63836', shrink=1, width=2,\
                                                                              headwidth=2,headlength=2))

    #在经济曲线上添加比赛结束标识
    win_team = get_match_win(match_id)
    if win_team == 1:
        se = '夜魇打出gg'
        plt.annotate(se,xy=((len(gold)-1),gold[(len(gold)-1)]),xytext=((len(gold)-1),(gold[(len(gold)-1)]-2*betw)),color='#c63836',fontsize=14,weight='black',arrowprops=dict(facecolor='#c63836',ec='#c63836', shrink=1, width=2,\
                                                                              headwidth=2,headlength=2))
    else:
        re = '天辉打出gg'
        plt.annotate(r10,xy=((len(gold)-1),gold[(len(gold)-1)]),xytext=((len(gold)-1),(gold[(len(gold)-1)]+2*betw)),color='#99aa40',fontsize=14,weight='black',arrowprops=dict(facecolor='#99aa40',ec='#99aa40', shrink=1, width=2,\
                                                                              headwidth=2,headlength=2))
    #加载一条y=0的曲线当做横坐标参考
    xx = []
    yy = []
    for x in range(0,len(duration)+3):
        xx.append('{}'.format(x))
        yy.append('0')
    plt.plot(xx,yy,color='#8a8a8a')


    #保存图表为png格式
    plt.savefig('f:/testdata/data/{}/{}.png'.format(match_id,match_id))

#get_show(5289041688)   #上下波动
#get_show(5302593898)    #一直向上
#get_show(5302642693)
