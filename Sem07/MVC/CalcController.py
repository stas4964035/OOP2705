from Model import *
from  View import *


class CalcController:
    def __init__(self):
        self.model = Model()
        self.view = View()
    def go_calc(self):
        self.model.set_a(self.view.input_data("input a: "))
        self.model.set_operation(self.view.input_data("set operation: "))

        self.model.set_b(self.view.input_data("input b: "))
        self.model.make()
        self.view.print_data_title("Result: ", self.model.get_result())
