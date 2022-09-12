# in-place operators x +=1, x -=1, x *=2, x /=2

from math import pi
import sys


def print_name_to_the_console(name):
    print("Hello ", name)
    print("""This is a string that spans multiple lines of code...""")

def repeat(a, isExclaim):
    result= a * 3

    if isExclaim:
        result += '!!!'    
    return result;

def area_of_rectangle(length, width):
    return length * width;

def largest_of_three_numbers(a, b, c):
    largest = a;

    if(b > largest):
        largest = b;
    if(c > largest):
        largest = c;
    return largest;        

def area_of_circle(radius):
    # PI * r2;
    return pi * (radius*radius);

def flying_time(miles_per_hours, miles):
    return miles / miles_per_hours;

def cube(number):
    return number * number * number;

def tip_calculator(amount):
    percentOf20 = (20/100) * amount;
    return float(percentOf20);

def temperature_in_farenheit(celsius):
   farenheight= (9/5 * celsius) + 32;

   if farenheight >=100:
      print('Boiling')
   else:
      print(farenheight);


def main():
    # print(repeat('Mango ', False));
    # print(repeat('Hurray', True));
    # print(area_of_rectangle(3, 20));
    # print('The largest number is: ' + str(sum_of_three_numbers(140, 40, 3)));

    
    # value = 89.89
    # print(f'The value is {value:.1f}');
    

    # cars = {'tires': 4, 'doors': 4};
    # print(f'cars={cars}')
    print(temperature_in_farenheit(15))
   

main();
