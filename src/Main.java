import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
     static ArrayList<Dev> devs = new ArrayList<>();
    static int pesquisaDev(String nomeUser, int senha1){
        for (Dev dev: Main.devs) {
            if (dev.getNome().equals(nomeUser) && dev.getSenha() == senha1) {
                return devs.indexOf(dev);
            }
        }
        return -1;
    }
    public static void main(String[] args) {

         Main.devs.add(new Dev("Camila", 1234));

         Bootcamp java = new Bootcamp("Java essencial", "Esse bootcamp têm o propósito de ensinar o básico de java para os devs incritos nele.");
         java.getConteudos().add(new Curso("Introdução ao java","Esse curso ensina o básico de java", 2));
         java.getConteudos().add(new Mentoria("O que você precisa saber para ser um profissional de TI",
                 "Nessa mentoria o expert Ciclano vai ensinar tudo sobre a carreira na área de " +
                         "TI, principais desafios, por onde começar, as diferentes profissões e" +
                         "as principais habilidades comportamentais e técnicas", LocalDate.now()));
        // administrador
        Administrador admin = new Administrador();
        Scanner scan = new Scanner(System.in);


        System.out.println("Digite o nome do usuário");
        String user = scan.next();
        System.out.println("Digite a senha");
        int senha = scan.nextInt();

        if(admin.getNome().equals(user)  && admin.getSenha() == senha) {
            boolean b = true;
            while (b) {
                System.out.println("1- adicionar curso");
                System.out.println("2- adicionar mentoria");
                System.out.println("3- adicionar bootcamp");
                System.out.println("4- adicionar conteúdo à um bootcamp");
                System.out.println("5- sair");
                System.out.println("Digite a opção");
                int op = scan.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Digite o nome do curso");
                        String nome = scan.next();
                        System.out.println("Digite a descrição do curso");
                        String descricao = scan.next();
                        System.out.println("Digite a carga horária do curso");
                        int CH = scan.nextInt();

                        Curso curso = new Curso(nome, descricao, CH);
                        admin.adicionarConteudo(curso);
                        break;
                    case 2:
                        System.out.println("Digite o nome da mentoria");
                        String titulo = scan.next();
                        System.out.println("Digite a descrição da mentoria");
                        String descricaoMentoria = scan.next();
                        System.out.println("Digite a data da mentoria");
                        LocalDate data = LocalDate.parse(scan.next());

                        Mentoria mentoria = new Mentoria(titulo, descricaoMentoria, data);
                        admin.adicionarConteudo(mentoria);
                        break;
                    case 3:
                        System.out.println("Digite o nome do Bootcamp");
                        String nomeBootcamp = scan.next();
                        System.out.println("Digite a descrição do Bootcamp");
                        String descricaoBootcamp = scan.next();
                        Bootcamp bootcamp1 = new Bootcamp(nomeBootcamp, descricaoBootcamp);
                        admin.adicionarBootcamp(bootcamp1);
                        break;
                    case 4:
                        System.out.println("Digite o nome do conteúdo");
                        String nomeConteudo = scan.next();
                        Conteudo x;
                        for (Conteudo c :
                                admin.conteudos) {
                            if (nomeConteudo == c.getTitulo()) {
                                if (c instanceof Curso) {
                                    admin.bootcamps.get(0).getConteudos().add(c);
                                } else if (c instanceof Mentoria) {
                                    admin.bootcamps.get(0).getConteudos().add(c);
                                } else {
                                    System.out.println("Você digitou um nome de conteúdo que não existe");
                                }
                            }
                        }
                        break;
                    case 5:
                        b = false;
                        break;
                }
            }
        }

        else {
            int index = Main.pesquisaDev(user, senha);
            if(index > -1){
                boolean b = true;
                while (b) {
                    System.out.println("1- Inscrever em um bootcamp");
                    System.out.println("2- progredir");
                    System.out.println("3- Calcular xp");
                    System.out.println("4- Sair");
                    System.out.println("Digite a opção");
                    int op = scan.nextInt();
                    switch (op){
                        case 1:
                            devs.get(index).inscreverBootcamp(java);
                            break;
                        case 2:
                            devs.get(index).progredir();
                            break;
                        case 3:
                            System.out.println(devs.get(index).calcularTotalXp());
                            break;
                        case 4:
                            b = false;
                            break;
                    }
                }
            }
            else {
                System.out.println("Você digitou errado o nome ou a senha!");
            }
        }
       System.out.println("Ola mundo");

       /* Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());*/

    }

}
