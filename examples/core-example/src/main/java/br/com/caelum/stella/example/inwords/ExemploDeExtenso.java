package br.com.caelum.stella.example.inwords;

import br.com.caelum.stella.inwords.FormatoDeExtenso;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

public class ExemploDeExtenso {

    public static void main(String[] args) {
        FormatoDeExtenso formato = new FormatoDeSegundosComMilesimos();
        NumericToWordsConverter converter = new NumericToWordsConverter(formato);
        String tempo = converter.toWords(0.05);
        String message = "Cibernautas demoram " + tempo + " a avaliar uma página.";
        System.out.println(message);
        
        tempo = converter.toWords(9.52);
        message =   "Técnico diz que Bolt poderia ter feito 100m em " + tempo;
        System.out.println(message);
    }
}
