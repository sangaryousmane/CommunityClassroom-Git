# w => writting
# r => reading 
# a => append

# with open('dict.txt', 'w') as f:
#     f.write('THis is great. see wether it is .');

# f.close();

import re


s = 'an example word:cat!!';
match = re.search(r'word:\w\w\w', s);

if not match:
   print('Not found');
else:
    print(f'found!! ', match.group());



try:
    print(3/0)
except:
    raise 'hello there!!'    