# This is the main file use to run codes of all files.

def health_check(time_hour, mood):

    if time_hour >0 and time_hour <=24:
        print('Drink More Water....')
        if mood == 'sleepy' and time_hour < 10:
            print('brew some coffee')
        elif mood == 'thirsty' or time_hour < 2:
            print('Drink lemonade')
        else:
            print('water');

def calculate_body_mass(mass):
    weight = mass / 9.8;

    if weight > 25 :
       print(f"""You're overweight, please see about that...""")
    elif weight <25 and weight >15:
       print(f"""Optimal!!! please exercise a little more.""")  
    elif weight < 15 and weight >10:
       print(f"""Good weight, more work!!""")
    elif weight <10 and weight > 5:
       print("Great workout so far.")
    else:
       print("NONE!!!")     

def difference_of_even_and_odd_number():
    array = [1, 3, 2, 5];
    sumEven = 0;
    sumOdd= 0;

    for i in array:
        if i % 2==0:
           sumEven +=i;
        else:
            sumOdd +=i;
    return sumOdd - sumEven;            

def donuts(count):
  # +++your code here+++

  if count <=9:
     return f'Number of donuts: {count}'
  else:   
     return f'Number of donuts: many';

# This method graps the first two and last characters
# and then print them out to the console.
def both_ends(s):
  # +++your code here+++

  if len(s) < 2:
     return ''
  else:   
     return s[0:2] + s[-2: ];

# This method takes two parameters and output their swap.
def mix_up(a, b):
  # +++your code here+++
  
  if len(a) >=2 and len(b) >=2:
     temp = a;
     a=b;
     b=temp;
  return a + temp;  


# This method add ly as suffix to a word if it ends in ing
# or add ing if it doesn't but the length of the word must be less than 3.
def verbing(s):
  # +++your code here+++

  if len(s) < 3:
     return s
  if s[-3: ] == 'ing':
     return s +'ly'
  else:
     return s+'ing'

def not_bad(s):

    notIndex=int(s.index('not'));
    badIndex=int(s.index('bad'));

    if notIndex == -1 or badIndex== -1 or badIndex < notIndex:
        return s;
    else:
        return s[0, notIndex] + ' good '+s[badIndex + 3];    





def main_method():
    # print(verbing('surprising'));
    print(difference_of_even_and_odd_number())
    print(fix_start('Gaming'))





main_method();