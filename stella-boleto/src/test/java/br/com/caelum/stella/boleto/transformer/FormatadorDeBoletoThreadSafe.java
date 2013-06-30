package br.com.caelum.stella.boleto.transformer;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class FormatadorDeBoletoThreadSafe {

    @Test
    public void deveFormatarDataComAcessoMultiplosThreads()
        throws Exception {

        int iterations = 500;
        ExecutorService exec = Executors.newFixedThreadPool(4);
        List<Future<String>> results = new ArrayList<Future<String>>();

        for (int i = 0; i < iterations; i++) {
            final int x = i;
            results.add(exec.submit(new Callable<String>() {
                public String call()
                    throws Exception {
                    Calendar c = Calendar.getInstance();
                    c.add(Calendar.MONTH, x);
                    return FormatadorDeBoleto.formataData(c);
                }
            }));
        }
        exec.shutdown();

        assertEquals(iterations, contarValoresUnicos(results));
    }

    @Test
    public void deveFormatarDecimaisComAcessoMultiplosThreads()
        throws Exception {

        int iterations = 5000;
        ExecutorService exec = Executors.newFixedThreadPool(4);
        List<Future<String>> results = new ArrayList<Future<String>>();

        for (int i = 0; i < iterations; i++) {
            final int x = i;
            final double v = new BigDecimal(x).doubleValue();
            results.add(exec.submit(new Callable<String>() {
                public String call()
                    throws Exception {
                    return FormatadorDeBoleto.formataValor(v);
                }
            }));
        }
        exec.shutdown();

        assertEquals(iterations, contarValoresUnicos(results));
    }

    private int contarValoresUnicos(List<Future<String>> results)
        throws Exception {
        Set<String> values = new HashSet<String>();
        for (Future<String> result : results) {
            values.add(result.get());
        }
        return values.size();
    }
}
