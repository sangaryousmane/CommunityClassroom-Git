
def sum_of_array_elements():
    arrays= [3, 4, 10, 9];
    sum =0;
    
    for array in arrays:
        sum +=array;
    print(sum);   


    if 190 in arrays: # Is 190 in the list ? return YES if true else return false.
        print('Huray');
    else:
        print("""Sorry! It's not in the list...""");    




def main():
    sum_of_array_elements()

    l = [];
    l.append(5);
    l.append(100);
    l.insert(0, 15); # add new element and push others right.
    print(l)
    # for i in range(21):
    #     if i % 2==0:
    #        print(i , ' is even')
    #     else:
    #         print(i , ' is odd');    
    







main();        