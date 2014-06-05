package br.com.caelum.stella;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Uma fluent interface para o cálculo de dígitos, que é usado em diversos boletos e 
 * documentos. 
 * 
 * Para exemplificar, o dígito do trecho 0000039104766 para os multiplicadores indo de 
 * 2 a 7 e usando módulo 11 é a seguinte:
 * 
 * <pre>
 *	0  0  0  0  0  3  9  1  0  4  7  6  6 (trecho numérico)
 *	2  7  6  5  4  3  2  7  6  5  4  3  2 (multiplicadores, da direita para a esquerda e ciclando)
 *	----------------------------------------- multiplicações algarismo a algarismo 
 *	 0  0  0  0  0  9 18  7  0 20 28 18 12 -- soma = 112
 * </pre>
 * 
 * Tira-se o módulo dessa soma e, então, calcula-se o complementar do módulo e, se o número 
 * for 0, 10 ou 11, o dígito passa a ser 1.
 * 
 * <pre>
 * 		soma = 112
 * 		soma % 11 = 2
 * 		11 - (soma % 11) = 9
 * </pre>
 * 
 * @author ceci
 */
public class DigitoPara {

	private LinkedList<Integer> numero;
	private List<Integer> multiplicadores = new ArrayList<Integer>();
	private boolean complementar;
	private int modulo;
	private boolean somarIndividual;
	private Map<Integer,String> substituicoes;

	/**
	 * Cria o objeto a ser preenchido com interface fluente e armazena o trecho numérico
	 * em uma lista de algarismos. Isso é necessário porque a linha digitada pode ser 
	 * muito maior do que um int suporta.
	 * 
	 * @param trecho Refere-se à linha numérica sobre a qual o dígito deve ser calculado
	 */
	public DigitoPara(String trecho) {
		comMultiplicadoresDeAte(2, 9);
		mod(11);
		substituicoes = new HashMap<Integer, String>();
		this.numero = new LinkedList<Integer>();
		char[] digitos = trecho.toCharArray();
		for (char digito : digitos) {
			this.numero.add(Character.getNumericValue(digito));
		}
		Collections.reverse(numero);
	}

	/**
	 * Para multiplicadores (ou pesos) sequenciais e em ordem crescente, esse método permite 
	 * criar a lista de multiplicadores que será usada ciclicamente, caso o número base seja
	 * maior do que a sequência de multiplicadores. Por padrão os multiplicadores são iniciados
	 * de 2 a 9. No momento em que você inserir outro valor este default será sobrescrito.
	 * 
	 * @param inicio Primeiro número do intervalo sequencial de multiplicadores
	 * @param fim Último número do intervalo sequencial de multiplicadores
	 * @return this
	 */
	public DigitoPara comMultiplicadoresDeAte(int inicio, int fim) {
		this.multiplicadores.clear();
		for (int i = inicio; i <= fim; i++) {
			multiplicadores.add(i);
		}
		return this;
	}

	/**
	 * Há documentos em que os multiplicadores não usam todos os números de um intervalo 
	 * ou alteram sua ordem. Nesses casos, a lista de multiplicadores pode ser passada 
	 * através de varargs.
	 * 
	 * @param multiplicadoresEmOrdem Sequência de inteiros com os multiplicadores em ordem
	 * @return this
	 */
	public DigitoPara comMultiplicadores(Integer... multiplicadoresEmOrdem) {
		this.multiplicadores = Arrays.asList(multiplicadoresEmOrdem);
		return this;
	}
	
	/**
	 * É comum que os geradores de dígito precisem do complementar do módulo em vez
	 * do módulo em sí. Então, a chamada desse método habilita a flag que é usada 
	 * no método mod para decidir se o resultado devolvido é o módulo puro ou seu 
	 * complementar.
	 * 
	 * @return this
	 */
	public DigitoPara complementarAoModulo() {
		this.complementar = true;
		return this;
	}

	public DigitoPara trocandoPorSeEncontrar(String substituto, Integer... i) {
		for (Integer integer : i) {
			substituicoes.put(integer, substituto);
		}
		return this;
	}

	/**
	 * @param modulo Inteiro pelo qual o resto será tirado e também seu complementar.
	 * 			O valor padrão é 11.
	 * 
	 * @return this
	 */
	public DigitoPara mod(int modulo) {
		this.modulo = modulo;
		return this;
	}
	
	/**
	 * Indica se ao calcular o módulo, se a soma dos resultados da multiplicação deve ser
	 * considerado digito a dígito.
	 * 
	 * Ex: 2 X 9 = 18, irá somar 9 (1 + 8) invés de 18 ao total.
	 * 
	 * @return this
	 */
	public DigitoPara somandoIndividualmente(){
		this.somarIndividual = true;
		return this;
	}
	
	/**
	 * Faz a soma geral das multiplicações dos algarismos pelos multiplicadores, tira o 
	 * módulo e devolve seu complementar.
	 * 
	 * @return String o dígito vindo do módulo com o número passado e configurações extra.
	 */
	public String calcula() {
		int soma = 0;
		int multiplicadorDaVez = 0;
		for (int algarismo : numero) {
			int multiplicador = multiplicadores.get(multiplicadorDaVez);
			int total = algarismo * multiplicador;
			soma += somarIndividual ? somaDigitos(total) : total;
			multiplicadorDaVez = proximoMultiplicador(multiplicadorDaVez);
		}
		int resultado = soma % modulo;
		if (complementar)
			resultado = modulo - resultado;
		
		if (substituicoes.containsKey(resultado)) {
			return substituicoes.get(resultado);
		}
		return String.valueOf(resultado);
	}
	
	
	/**
	 * soma os dígitos do número (até 2)
	 * 
	 * Ex: 18 => 9 (1+8), 12 => 3 (1+2)
	 * 
	 * @param total
	 * @return
	 */
	private int somaDigitos(int total) {
		return (total / 10) + (total % 10);
	}

	/**
	 * Devolve o próximo multiplicador a ser usado, isto é, a próxima posição da lista de
	 * multiplicadores ou, se chegar ao fim da lista, a primeira posição, novamente.
	 *  
	 * @param multiplicadorDaVez Essa é a posição do último multiplicador usado.
	 * @return próximo multiplicador
	 */
	private int proximoMultiplicador(int multiplicadorDaVez) {
		multiplicadorDaVez++;
		if (multiplicadorDaVez == multiplicadores.size())
			multiplicadorDaVez = 0;
		return multiplicadorDaVez;
	}

	/**
	 * Adiciona um dígito no final do trecho numérico.
	 *  
	 * @param digito É o dígito a ser adicionado.
	 * @return this
	 */
	public DigitoPara addDigito(String digito) {
		this.numero.addFirst(Integer.valueOf(digito));
		return this;
	}
}
