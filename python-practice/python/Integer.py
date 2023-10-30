class Integer:
    
    @staticmethod
    def abs(n):
        return abs(n)
    
    @staticmethod
    def clamp(value, min, max):
        if value < min:
            return min
        if value > max:
            return max
        return value
    
    @staticmethod
    def min(a, b):
        if a > b:
            return b
        return a
    
    @staticmethod
    def max(a, b):
        if a > b:
            return a
        return b
    
    @staticmethod
    def is_positive(n):
        if n > 0:
            return True
        return False
    
    @staticmethod
    def is_negative(n):
        if n < 0:
            return True
        return False
