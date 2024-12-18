package br.com.erudio;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
    method = RequestMethod.GET )
    public Double calc (

            @PathVariable(value = "numberOne" )String numberOne,
            @PathVariable(value = "numberTwo" )String numberTwo
            ) throws Exception{


          if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
              throw  new UnsupportedMathOperationException("Please set a numeric value");
          }
          return  convertToDouble(numberOne) + convertToDouble(numberTwo);
        }
    private Double convertToDouble(String strNumber) {
        if(strNumber == null )return 0D;
        String number = strNumber.replaceAll(",",".");
      if(isNumeric(number)) return Double.parseDouble(number);
      return 0D;
    }
    private boolean isNumeric (String strNumber){
        if( strNumber == null) {
            return false;
        }
         String number =strNumber.replaceAll(",",".");
         return  number.matches("[-+]?[0-9]*\\.?[0-9]+");
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
        return  convertToDouble(numberOne) * convertToDouble(numberTwo);
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
        return  convertToDouble(numberOne) / convertToDouble(numberTwo);
    }



}




