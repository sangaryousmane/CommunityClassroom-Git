# A. match_ends
# Given a list of strings, return the count of the number of
# strings where the string length is 2 or more and the first
# and last chars of the string are the same.
# Note: python does not have a ++ operator, but += works.

def match_ends(words):
    count =0;

    for word in words:
        if len(word) >=2 and (word[0]==word[-1]):
           count +=1;
    return count;


# Write a python program to get the smallest number from a list
def smallest_number():
      numbers=[3, 10, 4, 0, 19, -3, -120]
      least = numbers[0];
      for num in numbers:
          if num < least:
             least = num;
          else:
             num=least;
      return least;   

    # numbers= [3, 10, 4, 0, 19, -3];
    # smallest =numbers[0];
    # for num in numbers:
    #     if num < smallest:
    #        smallest=num;
    # return smallest;       

# Write a Python program to remove duplicates from a list.
def duplicates_in_list():
    dup_items = set();
    unique_items =[];
    array_elements = [10,20,30,20,10,50,60,40,80,50,40];

    for i in array_elements:
        if i not in dup_items:
           unique_items.append(i);
           dup_items.add(i);
    print(dup_items);        

# Check a list is empty or not
def isEmpty():
    empty = ['Plum', 'Orange', 'Fruits'];
    if not empty:
       print('List is empty ')
    else:
       print("""List isn't empty. Check Below....""");   


def remove_adjacent(numbers):
    result = [];
    for num in numbers:
        if len(result) == 0 or num !=result[-1]:
           result.append(num);
    return result;


# This function sorts the array of strings by their length
def sort_str_by_length():
    strs = ['ccc', 'aaaa', 'd', 'bb'];
    print(sorted(strs, key=len));

# This function returns the last letter or element of string/list
def last_element(s):
    return s[-1]


# B. front_x
# Given a list of strings, return a list with the strings
# in sorted order, except group all the strings that begin with 'x' first.
# e.g. ['mix', 'xyz', 'apple', 'xanadu', 'aardvark'] yields
# ['xanadu', 'xyz', 'aardvark', 'apple', 'mix']
# Hint: this can be done by making 2 lists and sorting each of them
# before combining them.

def front_x(words):
    x_one=[];
    other_one=[];

    for word in words:
        if word.startswith('x'):
           x_one.append(word);
        else:
           other_one.append(word);
    return sorted(x_one) + sorted(other_one);



# C. sort_last
# Given a list of non-empty tuples, return a list sorted in increasing
# order by the last element in each tuple.
# e.g. [(1, 7), (1, 3), (3, 4, 5), (2, 2)] yields
# [(2, 2), (1, 3), (3, 4, 5), (1, 7)]
# Hint: use a custom key= function to extract the last element form each tuple.

def last_element(s):
    return s[-1];

def sort_last(tuples):
    print(sorted(tuples, key=last_element)) # return a list in increasing order. 

def entrance(age):
    if age >=18:
       print('Allowed');
    else:
       print('Sorry');

# ticket price is 100
# ticket is free for children under 3yrs
def ages():
    total = 0;
    l = [18, 24, 2, 5, 42];
    for i in l:
        if i < 3:
            continue # skip any child that's less than three yrs...
        else:
            total +=100;
    return total;


def main():
    # d = {'a': 1, 'b': 2, 'c': 3, 'd': 4};
    # del d['d'] # This entry has been deleted.....
    # print(d)

    print(isEmpty())
    # numbers = [3, 10, 4, 0, 19];
    # print('Before ', numbers)

    # numbers.pop(2)
    # print('After ', numbers)


    # numbers.reverse();
    # print('After the list have reverse.', numbers)

    # print(sorted(numbers)); # Sorts list in ascending order....
    # print(sorted(numbers, reverse=True)) # Sorts in descending order....)

    # sort_str_by_length();
    # strs = ['BB', 'aa', 'cc'];
    # print(sorted(strs, key=last_element))





main();    