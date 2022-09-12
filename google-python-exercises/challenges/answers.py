
# A. donuts
# Given an int count of a number of donuts, return a string
# of the form 'Number of donuts: <count>', where <count> is the number
# passed in. However, if the count is 10 or more, then use the word 'many'
# instead of the actual count.
# So donuts(5) returns 'Number of donuts: 5'
# and donuts(23) returns 'Number of donuts: many'

def donuts(count):
    
    if count >=10:
       print(f'Number of donuts: Many');
    else:
       print(f'Number of donuts: {count}');     





# B. both_ends
# Given a string s, return a string made of the first 2
# and the last 2 chars of the original string,
# so 'spring' yields 'spng'. However, if the string length
# is less than 2, return instead the empty string.
def both_ends(s):

    if len(s) < 2:
       return ' ';
    else:
        return s[0:2] + s[-2:];       





# C. fix_start
# Given a string s, return a string
# where all occurences of its first char have
# been changed to '*', except do not change
# the first char itself.
# e.g. 'babble' yields 'ba**le'
# Assume that the string is length 1 or more.
# Hint: s.replace(stra, strb) returns a version of string s
# where all instances of stra have been replaced by strb.

def fix_start(s):
    front = s[0];  # jolly. j 
    back = s[1:];  # jolly. olly
    back_front =back.replace(front, "*"); 
    return front + back_front;


# D. MixUp
# Given strings a and b, return a single string with a and b separated
# by a space '<a> <b>', except swap the first 2 chars of each string.
# e.g.
#   'mix', pod' -> 'pox mid'
#   'dog', 'dinner' -> 'dig donner'
# Assume a and b are length 2 or more.
def mix_up(x, y):
    # swapped_a = b[:2] + a[2:]; 
    # swapped_b = a[:2] + b[2:];
    # return swapped_a + ' '+swapped_b;
    swapped_x= y[:2] + x[2:];
    swapped_y= x[:2] + y[2:];
    return swapped_x + ' '+swapped_y;



# D. verbing
# Given a string, if its length is at least 3,
# add 'ing' to its end.
# Unless it already ends in 'ing', in which case
# add 'ly' instead.
# If the string length is less than 3, leave it unchanged.
# Return the resulting string.
def verbing(s):
    if len(s) >=3:
       if not s.endswith('ing'):
          return s + 'ing';
       else:
          return s +'ly';   



# A. match_ends
# Given a list of strings, return the count of the number of
# strings where the string length is 2 or more and the first
# and last chars of the string are the same.
# Note: python does not have a ++ operator, but += works.
def match_ends(s):
    count = 0;

    for i in s:
        if len(i) >= 2 and s[0]==s[-1]:
           count +=1;
    return count;               


# B. front_x
# Given a list of strings, return a list with the strings
# in sorted order, except group all the strings that begin with 'x' first.
# e.g. ['mix', 'xyz', 'apple', 'xanadu', 'aardvark'] yields
# ['xanadu', 'xyz', 'aardvark', 'apple', 'mix']
# Hint: this can be done by making 2 lists and sorting each of them
# before combining them.
def front_x(words):
    started_with_x = [];
    started_with_other =[];

    for word in words:
        if word.startswith('x'):
           started_with_x.append(word);
        else:
           started_with_other.append(word);
    return sorted(started_with_x) + sorted(started_with_other);            


# C. sort_last
# Given a list of non-empty tuples, return a list sorted in increasing
# order by the last element in each tuple.
# e.g. [(1, 7), (1, 3), (3, 4, 5), (2, 2)] yields
# [(2, 2), (1, 3), (3, 4, 5), (1, 7)]
# Hint: use a custom key= function to extract the last element form each tuple.
def Mtn(s):
    return s[-1];

def sort_last(tuples):
    return sorted(tuples, key=Mtn);    


def search(text, word):

    if word in text:
       print("Word found")
    else:
       print("Word not found");     

# This calculates sum of digits...
def sum_of_digits(number):
    sum = 0;

    while number !=0:
          remainder = number % 10;
          sum +=remainder;
          number //=10;
    return sum;

# This is the fizzbuzz algorithm 
def fizzbuzz(number):
    for x in range(1, number):
        if x % 2==0:
           continue;
        elif x % 3==0 and x % 5==0:
             print(str(x), "FizzBuzz");
        elif x % 5 ==0:
             print(str(x), "Buzz");
        elif x % 3==0:
             print(str(x), "Fizz");
        else:
            print(str(x));

def main():

    print(fizzbuzz(35));
    # donuts(6);
    # print(both_ends('t'));
    # print(mix_up('dog','dinner'))
    # print(verbing('Talking'))
    # t =['mix', 'xyz', 'apple', 'xanadu', 'aardvark']
    # print(front_x(t))

    # p = [(1, 7), (1, 3), (3, 4, 5), (2, 2)] 
    # print(sort_last(p))

    # l = [1, 2, 10, 0, 1, 5, 6];
   
    # print(l);
    # print(f'Minimum is: {min(l)}');
    # print(f'Maximum is: {max(l)}');
    # l.reverse();
    # print(f'Reversed: {l}');
    # print(f'Total occurences of 1 is: {l.count(1)}')
    
    # x = ".".join(['John', 'Paul', 'Peter']);
    # print(x);

    # # The split function is also awesome
    # s = "some lemonade won't hurt";
    # print(s.split(' '));

    # search('This is awesome', 'texting')
   

main();    