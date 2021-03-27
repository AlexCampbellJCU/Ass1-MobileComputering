package au.edu.jcu.assignment1;

import android.widget.EditText;

public class Converter {
    private double constant;

    public Converter(Unit from, Unit to) {
        if (to == Unit.CENTIMETER) {
            constant = 2.54;
        } else if (to == Unit.FOOT) {
            constant = 0.0833333;
        } else if (to == Unit.YARD) {
            constant = 0.0277778;
        } else if (to == Unit.METER) {
            constant = 0.0254;
        } else if (to == Unit.MILE) {
            constant = 1.5783e-5;
        } else if (to == Unit.KILOMETER) {
            constant = 2.54e-5;
        }
        if (to == Unit.INCH) {
            constant = 0.393701;
        } else if (to == Unit.FOOT) {
            constant = 0.0328084;
        } else if (to == Unit.YARD) {
            constant = 0.0109361;
        } else if (to == Unit.METER) {
            constant = 0.01;
        } else if (to == Unit.MILE) {
            constant = 6.2137e-6;
        } else if (to == Unit.KILOMETER) {
            constant = 1e-5;
        }
        if (to == Unit.INCH) {
            constant = 12;
        } else if (to == Unit.CENTIMETER) {
            constant = 30.48;
        } else if (to == Unit.YARD) {
            constant = 0.333333;
        } else if (to == Unit.METER) {
            constant = 0.3048;
        } else if (to == Unit.MILE) {
            constant = 0.000189394;
        } else if (to == Unit.KILOMETER) {
            constant = 0.0003048;
        }
        if (to == Unit.INCH) {
            constant = 36;
        } else if (to == Unit.CENTIMETER) {
            constant = 91.44;
        } else if (to == Unit.FOOT) {
            constant = 3;
        } else if (to == Unit.METER) {
            constant = 0.9144;
        } else if (to == Unit.MILE) {
            constant = 0.000568182;
        } else if (to == Unit.KILOMETER) {
            constant = 0.0009144;
        }
        if (to == Unit.INCH) {
            constant = 39.3701;
        } else if (to == Unit.CENTIMETER) {
            constant = 100;
        } else if (to == Unit.FOOT) {
            constant = 3.28084;
        } else if (to == Unit.YARD) {
            constant = 1.09361;
        } else if (to == Unit.MILE) {
            constant = 0.000621371;
        } else if (to == Unit.KILOMETER) {
            constant = 0.001;
        }
        if (to == Unit.INCH) {
            constant = 63360;
        } else if (to == Unit.CENTIMETER) {
            constant = 160934;
        } else if (to == Unit.FOOT) {
            constant = 5280;
        } else if (to == Unit.YARD) {
            constant = 1760;
        } else if (to == Unit.METER) {
            constant = 1609.34;
        } else if (to == Unit.KILOMETER) {
            constant = 1.60934;
        }
        if (to == Unit.INCH) {
            constant = 39370.1;
        } else if (to == Unit.CENTIMETER) {
            constant = 100000;
        } else if (to == Unit.FOOT) {
            constant = 3280.84;
        } else if (to == Unit.YARD) {
            constant = 1093.61;
        } else if (to == Unit.METER) {
            constant = 1000;
        } else if (to == Unit.MILE) {
            constant = 0.621371;
        }


    }

    public double convert(double input) {
        return input * constant;
    }

}