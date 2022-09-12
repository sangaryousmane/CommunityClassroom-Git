
def numbers():
    d = {};
    d['china']= 15000000;
    d['liberia'] = 2000;
    d['Guinea'] = 15000;

    print(d.items());
    
    if 'liberia' in d:
        print(d['liberia'])
        print(d.copy())


def main():
    numbers();


main();