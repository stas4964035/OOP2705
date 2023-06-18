class Model:
    def __init__(self):
        self.a = 0
        self.b = 0
        self.operation = ''
        self.result = 0

    def make(self):
        if self.operation == "+":
            self.result = int(self.get_a()) + int(self.get_b())
        if self.operation == '-':
            print('this -')
            self.result = int(self.get_a()) - int(self.get_b())
        if self.operation == '*':
            self.result = int(self.get_a()) * int(self.get_b())
        if self.operation == '/':
            self.result = int(self.get_a()) / int(self.get_b())

    def get_result(self):
        return self.result

    def set_a(self, a):
        self.a = a

    def set_b(self, b):
        self.b = b

    def set_operation(self, o):
        self.operation = o

    def get_a(self):
        return self.a

    def get_b(self):
        return self.b

    def get_operation(self):
        return self.operation
