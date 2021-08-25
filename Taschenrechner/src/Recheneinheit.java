
public class Recheneinheit { 

  private double zahlspeicher;  

  private String operatorspeicher;  

 

  public Recheneinheit() { 

    zuruecksetzen(); 

  } 

 

  public void zuruecksetzen(){ 

    zahlspeicher = 0; 

    operatorspeicher = "";   

  }            

 

  public double gibZahlspeicher() { 

    return zahlspeicher; 

  } 

  

  public void speichereGrundrechenoperator(String pNaechsterOperator) { 

    operatorspeicher = pNaechsterOperator; 

  } 

 

  public void verarbeiteGrundrechenoperator(double pZahl) { 

    if (operatorspeicher.equals("")) { 

      zahlspeicher = pZahl; 

    } else { 

      zahlspeicher = ermittleRechenergebnis(zahlspeicher,  

                                     operatorspeicher, pZahl); 

      operatorspeicher = ""; 

    }     

  } 

 

  public double liefereQuadratwurzel(double pZahl) { 

    return Math.sqrt(pZahl); 

  } 

 

  public double liefereProzentwert(double pZahl) { 

    return pZahl / 100; 

   } 

 

  public double liefereGegenzahl(double pZahl) { 

     return -pZahl; 

  } 

 

  private double ermittleRechenergebnis(double pZahl1,  

                                    String pOperator, double pZahl2) { 

    double ergebnis = 0; 

    if (pOperator.equals("+")) { 

        ergebnis = pZahl1 + pZahl2; 

    } else if(pOperator.equals("-")) { 

        ergebnis = pZahl1 - pZahl2; 

    } else if (pOperator.equals("*")) { 

        ergebnis = pZahl1 * pZahl2; 

    } else if (pOperator.equals("/")) { 

        ergebnis = pZahl1 / pZahl2;  

    } 

    return ergebnis; 

  } 

} 

