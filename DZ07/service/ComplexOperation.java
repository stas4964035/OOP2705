package DZ07.service;

import DZ07.model.complex.Complex;

public interface ComplexOperation {
    Complex mathOperation(Complex c1, Complex c2);
    void print(Complex complex);
}
