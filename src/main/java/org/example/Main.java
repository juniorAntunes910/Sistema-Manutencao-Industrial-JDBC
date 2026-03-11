package org.example;

import org.example.DAO.MaquinaDAO;
import org.example.DAO.PecaDAO;
import org.example.DAO.TecnicoDAO;
import org.example.DTO.MaquinaDTO;
import org.example.Entity.Maquina;
import org.example.Entity.Pecas;
import org.example.Entity.Tecnicos;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static final Scanner SC = new Scanner(System.in);
    static final MaquinaDAO MAQUINA_DAO = new MaquinaDAO();
    static final TecnicoDAO TECNICO_DAO = new TecnicoDAO();
    static final PecaDAO PECA_DAO = new PecaDAO();
    public static void main(String[] args) {
        menuInicio();
    }
    public static void menuInicio(){
        while (true) {
            System.out.println("""
                  ===  Sistema de Manutenção Industrial ===
                    
                    1 Cadastrar Máquina 
                    2 Cadastrar Técnico
                    3 Cadastrar Peça 
                    4 Criar Ordem de Manutenção 
                    5 Associar Peças à Ordem
                    6 Executar Manutenção 
                    
                    0 Sair
                     
                    """);
            int menu = SC.nextInt();
            switch (menu) {
                case 1:
                    cadastrarMaquina();
                    break;
                case 2:
                    cadastrarTecnico();
                    break;
                case 3:
                    cadastrarPeca();
                    break;
                case 4:
                    criarOrdemManutencao();
                    break;
                case 5:
                    associarPecasOrdem();
                    break;
                case 6:
                    executarManutencao();
                    break;
                case 0:
                    System.exit(0);

            }
        }
    }

    private static void cadastrarMaquina() {
        String nomeMaquina;
        String setorMaquina;
        SC.nextLine();
        ArrayList<MaquinaDTO> listaNomesMaquinas = MAQUINA_DAO.retornaMaquinaNome();
        if (listaNomesMaquinas == null) {
            listaNomesMaquinas.add(new MaquinaDTO("NomeTesteNingueNuncaVaiUsarMetodoAlternativoNaoEGambiarra1", "SetorParaNaoNulo"));
        }
        do {
            System.out.println("Nome da Máquina: ");
            nomeMaquina = SC.nextLine();
            System.out.println("Setor da Máquina: ");
            setorMaquina = SC.nextLine();
            if(listaNomesMaquinas.contains(
                    new MaquinaDTO(
                            nomeMaquina,
                            setorMaquina
                            )
                        )
            ){
                System.out.println("Maquina Ja existe!");
                return;
            }
        }while(nomeMaquina.isBlank() || setorMaquina.isBlank());
        MAQUINA_DAO.cadastrarMaquina(new Maquina(nomeMaquina,
                setorMaquina,
                "OPERACIONAL"));
        //Usei essa logica para tentar algo novo, sei que tem varios formas mais faceis de se fazer
    }

    private static void cadastrarTecnico() {
        String nome;
        String setor;
        ArrayList<String> listaNomes = TECNICO_DAO.listaNomes();
        SC.nextLine();
        do{
            System.out.println("Nome do Tecnico: ");
            nome = SC.nextLine();
            if(listaNomes.contains(nome)){
                System.out.println("Nome ja existe!");
                return;
            }
            System.out.println("Nome do Setor: ");
            setor = SC.nextLine();

        }while (nome.isBlank() || setor.isBlank());
        TECNICO_DAO.inserirTecnico(
                new Tecnicos(
                        nome,
                        setor
                )
        );
    }

    private static void cadastrarPeca() {
        String nomePeca;
        double quantidade;
        ArrayList<String> listaNomes = PECA_DAO.listaNomes();
        SC.nextLine();
        do{
            System.out.println("Nome peça: ");
            nomePeca = SC.nextLine();
            System.out.println("Quantidade peça (Valida >= 0): ");
            quantidade = SC.nextDouble();
        }while (nomePeca.isBlank() || quantidade < 0);
        PECA_DAO.cadastrarPeca(
                new Pecas(
                        nomePeca,
                        quantidade
                )
        );
    }

    private static void criarOrdemManutencao() {
    }

    private static void associarPecasOrdem() {
    }

    private static void executarManutencao() {
    }
}