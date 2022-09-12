
from math import pi # explicit
from sys import *   # wildcard  
from math import sqrt as square_root # This is using self-define name for imports. 
import mailbox # This is the easiest way to import modules.

# Convert celsius to fahrenheit: F = 9/5 * c + 32
def fahrenheit(celsius):
    return (9/5 * celsius) + 32;
    
def area_of_circle(radius):
    area =pi * (radius * radius);
    return f"The circle's area is: {area:.2f}";

def trying_excpetions(num1, num2):
    
    try:
        result = num1/num2;
        print(result);
    except(ValueError, ZeroDivisionError):
        raise ZeroDivisionError (f"{num1} can't be divided by {num2}")

def reading_files(f):
    file = open(f);
    print(f.read(file))
    file.close();


def main():
    # print(area_of_circle(10));
    # print(help('sys'))

    reading_files('play.txt');

    trying_excpetions(9, 0);
    


main();    