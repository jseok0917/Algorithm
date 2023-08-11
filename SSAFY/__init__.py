##########
# 폴더 생성
import os 


# 날짜
exams = ['IM', 'A']
days = [i  for i in range(1, 28)]

total = exams + days

# print(total)

for t in total:
    # exams
    if type(t) is str:
        os.system(f'mkdir {t}')
        os.chdir(f'{t}')
        
    # days
    else:
        day = str()
        if t <=9:
            day = '0' + str(t)
        else:
            day = str(t)
            
        os.system(f'mkdir day_{day}')
        os.chdir(f'day_{day}')
        
    os.system(f'touch .gitkeep README.md')
    os.chdir('..')