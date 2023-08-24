import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class CRUDtest {
    public static void main(String[] args) {
        Connection connection = Conection.getConnection();

        if (connection != null) {
            ClienteDAO clienteDAO = new ClienteDAO(connection);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Informe o nome do novo cliente: ");
            String novoNome = scanner.nextLine();
            System.out.print("Informe o email do novo cliente: ");
            String novoEmail = scanner.nextLine();

            Cliente novoCliente = new Cliente();
            novoCliente.setName(novoNome);
            novoCliente.setEmail(novoEmail);
            clienteDAO.insert(novoCliente);
            System.out.println("Novo cliente inserido com sucesso!");

            List<Cliente> clientes = clienteDAO.getAllClientes();
            System.out.println("Lista de clientes:");

            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId());
                System.out.println("Nome: " + cliente.getName());
                System.out.println("Email: " + cliente.getEmail());
            }

            if (!clientes.isEmpty()) {
                System.out.print("Digite o ID do cliente para atualização: ");
                int idClienteAtualizacao = scanner.nextInt();
                scanner.nextLine();

                Cliente clienteAtualizar = new Cliente();
                clienteAtualizar.setId(idClienteAtualizacao);
                System.out.print("Digite o novo nome: ");
                clienteAtualizar.setName(scanner.nextLine());
                System.out.print("Digite o novo email: ");
                clienteAtualizar.setEmail(scanner.nextLine());

                clienteDAO.update(clienteAtualizar);
                System.out.println("Atualização feita!");
            }

            if (!clientes.isEmpty()) {
                System.out.print("Informe o ID do cliente a ser deletado: ");
                int idDeletar = scanner.nextInt();

                clienteDAO.delete(idDeletar);
                System.out.println("Cliente deletado com sucesso!");
            }

            scanner.close();
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}