/* *****************************************************************************
 * C�digos desenvolvidos pelos seguintes alunos
 *
 * @author Claudson Bispo Martins Santos    201410042132
 * @author Edgar Vieira Lima Neto           201410042150
 * @author Guilherme Boroni Pereira         201410042197
 * ****************************************************************************/

package ed2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Ed2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException,
                                                  IOException {
        // Obt�m o momento em que o algoritmo come�ou a ser processado
        // long startTime = System.currentTimeMillis();
        SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
        Date startTime = new Date();
        System.out.println("In�cio em: " + ft.format(startTime));
        
        // Instancia manualmente 3 alunos
        Aluno first = new Aluno(27, "Adalgisa", "Rua 4, 5", (short) 15, "F", "adalgisa@semcoracao.com");
        Aluno second = new Aluno(18, "Tairone", "Rua 5, 71", (short) 37, "M", "tairone@cigano.com");
        Aluno third = new Aluno(29, "Levy Vianna", "Rua 6, 45", (short) 14, "M", "levyvianna@volume5.com");
        Aluno vazio = new Aluno(0, "", "", (short) 0, "", "");

        // Instancia o manipulador de arquivos
        //String arquivo = "data\\enem_seq.db";
        String arquivo = "data\\testes.db";
        //ManipuladorSimples teste = new ManipuladorSimples(arquivo);
        //ManipuladorSequencial teste = new ManipuladorSequencial(arquivo);
        OrganizadorBrent teste = new OrganizadorBrent(arquivo);
        teste.inicializaArquivo(vazio);
        

        // Persiste os alunos instanciados manualmente no arquivo
        // teste.addReg(first);
        // teste.addReg(second);
        // teste.addReg(third);
        teste.addReg(first);
        teste.listarArquivo();
        teste.addReg(second);
        teste.listarArquivo();
        teste.addReg(third);
        teste.listarArquivo();
        
        
        // Instancia e persiste automaticamente 1 Milh�o de registros no arquivo
        /*Aluno novo = null;
        for (int i = 1; i <= 1000000; i++) {
            novo = new Aluno(i, String.valueOf(i), "Rua 6, 45", (short) 14, "M", "email@com");
            teste.addReg(novo);
        }*/
        
        // L� as matriculas a serem buscadas
        /*ManipuladorSequencial teste2 = new ManipuladorSequencial("data\\selected.db");
        int[] selected = teste2.lerSelecionados();*/
        
        // Realiza a busca sequencial das matriculas
        /*for (int i = 0; i < 1000; i++) {
            Aluno a = teste.getReg(selected[i]);
            if (a != null) System.out.println("[ " + i + " ] " +
                    a.getMatricula() + " | " + 
                    a.getNome().substring(0,15) + " | " +
                    a.getEmail());
        }*/
  
        // Obt�m do arquivo os alunos que foram instanciados manualmente
        /*Aluno b = teste.getReg(8);
        if (b != null) System.out.println(b.getMatricula() + " | " + 
                                          b.getNome().substring(0,15) + " | " +
                                          b.getEmail());
        b = teste.getReg(15);
        if (b != null) System.out.println(b.getMatricula() + " | " + 
                                          b.getNome().substring(0,15) + " | " +
                                          b.getEmail());
        b = teste.getReg(7);
        if (b != null) System.out.println(b.getMatricula() + " | " + 
                                          b.getNome().substring(0,15) + " | " +
                                          b.getEmail());*/

        // Deleta do arquivo os alunos que foram instanciados manualmente
        /*Aluno del = teste.delReg(8);
        if (del != null)
            System.out.println("O aluno " + del.getNome() +
                               " (" + del.getMatricula() + ") foi removido.");
        del = teste.delReg(15);
        if (del != null)
            System.out.println("O aluno " + del.getNome() +
                               " (" + del.getMatricula() + ") foi removido.");
        del = teste.delReg(7);
        if (del != null)
            System.out.println("O aluno " + del.getNome() +
                               " (" + del.getMatricula() + ") foi removido.");*/

        // Obt�m o momento em que o algoritmo terminou de ser processado
        // long endTime   = System.currentTimeMillis();
        Date endTime = new Date();
        // Calcula e imprime o tempo total de execu��o em milisegundos
        long totalTime = endTime.getTime() - startTime.getTime();
        
        // Computa a diferen�a detalhadamente
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);
        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliSecondsRest = totalTime;
        for (TimeUnit unit : units) {
            long diff = unit.convert(milliSecondsRest,TimeUnit.MILLISECONDS);
            long diffInMilliSecondsForUnit = unit.toMillis(diff);
            milliSecondsRest = milliSecondsRest - diffInMilliSecondsForUnit;
            result.put(unit,diff);
        }
        
        System.out.println("---------------------");
        System.out.println("Hora de In�cio:    " + ft.format(startTime));
        System.out.println("Hora do T�rmino:   " + ft.format(endTime));
        System.out.println("");
        System.out.println("Tempo de Execu��o: " + totalTime + " ms");
        /*System.out.println("                   " + (totalTime/1000) + " s");
        System.out.println("                   " +
                result.get(TimeUnit.HOURS) + " h : " +
                result.get(TimeUnit.MINUTES) + " min : " +
                result.get(TimeUnit.SECONDS) + " s");*/
    }
    
}