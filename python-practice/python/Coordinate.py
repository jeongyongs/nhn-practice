class Coordinate:
    def __init__(self, x, y):
        # 생성자
        self.x = x
        self.y = y

    def distance(self, other):
        x_diff_sq = (self.x - other.x) ** 2
        y_diff_sq = (self.y - other.y) ** 2
        return (x_diff_sq + y_diff_sq) ** 0.5
    
    def __str__(self):
        return '<{}, {}>'.format(self.x, self.y)
    
    def __add__(self, other):
        pass

c1 = Coordinate(2, 2)
c2 = Coordinate(2, 4)

print(c1.distance(c2))
print(c1)
c1 + c2
print(c1)