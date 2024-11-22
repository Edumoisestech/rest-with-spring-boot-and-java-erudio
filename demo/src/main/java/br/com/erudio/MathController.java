package br.com.erudio;

import br.com.erudio.convertes.NumberConverter;
import br.com.erudio.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static br.com.erudio.convertes.NumberConverter.convertToDouble;
import static br.com.erudio.convertes.NumberConverter.isNumeric;

@RestController
public class MathController {

    private static final AtomicLong counter = new AtomicLong();
    private final SimpleMath math =  new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
    method = RequestMethod.GET )
    public Double calc (

            @PathVariable(value = "numberOne" )String numberOne,
            @PathVariable(value = "numberTwo" )String numberTwo
            ) throws Exception{


          if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
              throw  new UnsupportedMathOperationException("Please set a numeric value");
          }
          return  (math.sum(convertToDouble(numberOne) , convertToDouble(numberTwo)));
        }


    @RequestMapping(value = "/multi/{numberOne}/{numberTwo}",
            method = RequestMethod.GET )
    public Double multi (

            @PathVariable(value = "numberOne" )String numberOne,
            @PathVariable(value = "numberTwo" )String numberTwo
    ) throws Exception{


        if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
            throw  new UnsupportedMathOperationException("Please set a numeric value");
        }
   return  (math.multiplication(convertToDouble(numberOne) , convertToDouble(numberTwo)));
    }

    @RequestMapping(value = "/divisor/{numberOne}/{numberTwo}",
            method = RequestMethod.GET )

    public Double divisor (

            @PathVariable(value = "numberOne" )String numberOne,
            @PathVariable(value = "numberTwo" )String numberTwo
    ) throws Exception{


        if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
            throw  new UnsupportedMathOperationException("Please set a numeric value");
        }
        return  (math.division(convertToDouble(numberOne) , convertToDouble(numberTwo)));
    }

    public  Double substract (

            @PathVariable(value = "numberOne" )String numberOne,
            @PathVariable(value = "numberTwo" )String numberTwo
    ) throws Exception{


        if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
            throw  new UnsupportedMathOperationException("Please set a numeric value");
        }
        return  (math.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo)));
    }

    public  Double mean (

            @PathVariable(value = "numberOne" )String numberOne,
            @PathVariable(value = "numberTwo" )String numberTwo
    ) throws Exception{


        if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
            throw  new UnsupportedMathOperationException("Please set a numeric value");
        }
        return  (math.mean(convertToDouble(numberOne), convertToDouble(numberTwo)));
    }



    @RequestMapping(value = "/square/{numberOne}",
            method = RequestMethod.GET )
    public Double squareRoot (

            @PathVariable(value = "numberOne" )String numberOne
    ) throws Exception{


        if(!isNumeric(numberOne)){
            throw  new UnsupportedMathOperationException("Please set a numeric value");
        }
        return  (math.squareRoot(convertToDouble(numberOne)));
    }
    Double square (

            @PathVariable(value = "numberOne" )String numberOne
    ) throws Exception{


        if(!isNumeric(numberOne)){
            throw  new UnsupportedMathOperationException("Please set a numeric value");
        }
        return  (math.squareRoot(convertToDouble(numberOne)));
    }


}




