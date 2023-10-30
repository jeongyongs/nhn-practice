class Fraction:
    def __init__(self, num, denom):
        self.num = num
        self.denom = denom

    def __str__(self):
        if self.num == 0:
            return '0'
        symbol = ''
        margin = ''
        if (self.num < 0 and self.denom > 0) or (self.num > 0 and self.denom < 0):
            symbol = '- '
            margin = '  '
        self.num = abs(self.num)
        self.denom = abs(self.denom)
        if self.num == self.denom:
            return '{}1'.format(symbol)
        return '{}{:^3}\n{}───\n{}{:^3}'.format(margin, self.num, symbol, margin, self.denom)
    
    def __add__(self, other):
        top = self.num * other.denom + self.denom * other.num
        bottom = self.denom * other.denom
        c = self.rational(top, bottom)
        return Fraction(top // c, bottom // c)
    
    def __sub__(self, other):
        top = self.num * other.denom - self.denom * other.num
        bottom = self.denom * other.denom
        c = self.rational(top, bottom)
        return Fraction(top // c, bottom // c)

    def rational(self, a, b):
        while b != 0:
            t = a % b
            (a,b) = (b,t)
        return abs(a)

f1 = Fraction(1, 4)
f2 = Fraction(1, 4)

print(f1)
print()
print(f2)
print()
print(f1 + f2)
