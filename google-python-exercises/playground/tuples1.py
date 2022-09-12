# Play with tuples.... Tuples are immutable.

fruits = ('Ben', 'HBUT', 25);

print(f"""
      {fruits[0]} is {fruits[2]} years old
      and he will be graduating 
      from {fruits[1]} soon.""")

names = ['Prince']
print(names)


# List comprehension. This is an advance concept. 
def list_of_squares():
    l = [1, 2, 3, 4, 5, 6];
    iteraterable = [n*n for n in l if n%2==0];
    print(iteraterable);

def main():
    list_of_squares();




main();