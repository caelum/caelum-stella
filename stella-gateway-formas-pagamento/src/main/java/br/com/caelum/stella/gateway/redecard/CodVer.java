package br.com.caelum.stella.gateway.redecard;

import java.util.Date;

/**
 * Classe temporaria achada na net para fazer calculo de um numero da master. Apenas está alterada para ter um metod que calcula
 * o tal do numero, antes ficava tudo no metodo main escrevendo em um arquivo.
 * @author Alberto Pc
 *
 */
class CodVer {
	public static void main(String[] args) {

	}
	/**
	 * 
	 * @param args numeroFiliacao valor ip
	 * @return
	 */
	public static String calculaCodigoVerificacao(String... args){
        Date date = new Date();  
        if (args.length < 3) {  
        	return "Numero de argumentos invalidos!\n\nUso:java CodVer <numfil> <total> <endereco ip remoto> \n<numfil>: Numero de filiacao\n<total>: Valor total da compra\n<endereo ip remoto>: IP Address do browser cliente";    
       } else {  
           for (int i = 0; i < args.length; i++) {  
               /* empty */  
           }  
           int numfil = 0;  
           try {  
               numfil = Integer.parseInt(args[0]);               
           } catch (Exception exception) {  
               return "Erro - Numero de filiacao invalido.";  
           }  
           int total = 0;  
           try {  
               String parteInteira = args[1]  
                       .substring(0, args[1].indexOf('.'));  
               total = Integer.parseInt(parteInteira);               
           } catch (Exception exception) {  
               return "Erro - Preco invalido. Use: ####.##";                 
           }  
           int segundosAgora = date.getSeconds();  
           int segundosAgoraCodificados = 0;  
           switch (segundosAgora) {  
           case 0:  
               segundosAgoraCodificados = 11;  
               break;  
           case 1:  
               segundosAgoraCodificados = 17;  
               break;  
           case 2:  
               segundosAgoraCodificados = 21;  
               break;  
           case 3:  
               segundosAgoraCodificados = 31;  
               break;  
           case 4:  
               segundosAgoraCodificados = 56;  
               break;  
           case 5:  
               segundosAgoraCodificados = 34;  
               break;  
           case 6:  
               segundosAgoraCodificados = 42;  
               break;  
           case 7:  
               segundosAgoraCodificados = 3;  
               break;  
           case 8:  
               segundosAgoraCodificados = 18;  
               break;  
           case 9:  
               segundosAgoraCodificados = 13;  
               break;  
           case 10:  
               segundosAgoraCodificados = 12;  
               break;  
           case 11:  
               segundosAgoraCodificados = 18;  
               break;  
           case 12:  
               segundosAgoraCodificados = 22;  
               break;  
           case 13:  
               segundosAgoraCodificados = 32;  
               break;  
           case 14:  
               segundosAgoraCodificados = 57;  
               break;  
           case 15:  
               segundosAgoraCodificados = 35;  
               break;  
           case 16:  
               segundosAgoraCodificados = 43;  
               break;  
           case 17:  
               segundosAgoraCodificados = 4;  
               break;  
           case 18:  
               segundosAgoraCodificados = 19;  
               break;  
           case 19:  
               segundosAgoraCodificados = 14;  
               break;  
           case 20:  
               segundosAgoraCodificados = 9;  
               break;  
           case 21:  
               segundosAgoraCodificados = 20;  
               break;  
           case 22:  
              segundosAgoraCodificados = 23;  
              break;  
          case 23:  
              segundosAgoraCodificados = 33;  
              break;  
          case 24:  
              segundosAgoraCodificados = 58;  
              break;  
          case 25:  
              segundosAgoraCodificados = 36;  
              break;  
          case 26:  
              segundosAgoraCodificados = 44;  
              break;  
          case 27:  
              segundosAgoraCodificados = 5;  
              break;  
          case 28:  
              segundosAgoraCodificados = 24;  
              break;  
          case 29:  
              segundosAgoraCodificados = 15;  
              break;  
          case 30:  
              segundosAgoraCodificados = 62;  
              break;  
          case 31:  
              segundosAgoraCodificados = 25;  
              break;  
          case 32:  
              segundosAgoraCodificados = 34;  
              break;  
          case 33:  
              segundosAgoraCodificados = 59;  
              break;  
          case 34:  
              segundosAgoraCodificados = 37;  
              break;  
          case 35:  
              segundosAgoraCodificados = 45;  
              break;  
          case 36:  
              segundosAgoraCodificados = 6;  
              break;  
          case 37:  
              segundosAgoraCodificados = 25;  
              break;  
          case 38:  
              segundosAgoraCodificados = 16;  
              break;  
          case 39:  
              segundosAgoraCodificados = 27;  
              break;  
          case 40:  
              segundosAgoraCodificados = 63;  
              break;  
          case 41:  
              segundosAgoraCodificados = 26;  
              break;  
          case 42:  
              segundosAgoraCodificados = 35;  
              break;  
          case 43:  
              segundosAgoraCodificados = 60;  
              break;  
          case 44:  
              segundosAgoraCodificados = 38;  
              break;  
          case 45:  
              segundosAgoraCodificados = 46;  
              break;  
          case 46:  
              segundosAgoraCodificados = 7;  
              break;  
          case 47:  
              segundosAgoraCodificados = 26;  
              break;  
          case 48:  
              segundosAgoraCodificados = 17;  
              break;  
          case 49:  
              segundosAgoraCodificados = 28;  
              break;  
          case 50:  
              segundosAgoraCodificados = 14;  
              break;  
          case 51:  
              segundosAgoraCodificados = 36;  
              break;  
          case 52:  
              segundosAgoraCodificados = 2;  
              break;  
          case 53:  
              segundosAgoraCodificados = 39;  
              break;  
          case 54:  
              segundosAgoraCodificados = 47;  
              break;  
          case 55:  
              segundosAgoraCodificados = 8;  
              break;  
          case 56:  
              segundosAgoraCodificados = 29;  
              break;  
          case 57:  
              segundosAgoraCodificados = 22;  
              break;  
          case 58:  
              segundosAgoraCodificados = 55;  
              break;  
          case 59:  
              segundosAgoraCodificados = 33;  
              break;  
          }  
          segundosAgora = segundosAgoraCodificados;  
          String pad;  
          if (segundosAgora < 10)  
              pad = "0";  
          else  
              pad = "";  
          String ipremoto = args[2];  
          int tamIP = ipremoto.length();  
          int i_5_ = total + segundosAgora;  
          int i_6_ = segundosAgora + tamIP;  
          int i_7_ = segundosAgora * numfil;  
          String string_8_ = String.valueOf(i_7_);  
          return String.valueOf(i_7_) + "" + i_5_ + "" + i_6_ + "-"  
                  + string_8_.length() + pad + segundosAgora;  
          //int i_9_ = i_7_ / segundosAgora;  
      }		
	}

}