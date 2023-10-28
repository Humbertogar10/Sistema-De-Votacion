import java.util.Scanner;

public class SistemaDeVotaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxUsuarios = 100;
        String[][] usuarios = new String[maxUsuarios][3]; 
        int numUsuariosRegistrados = 0;

        String[] candidatos = {"Candidato A", "Candidato B", "Candidato C"};
        int[] votos = new int[candidatos.length];

        while (true) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Iniciar sesión y votar");
            System.out.println("3. Ver resultados de votación");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre del usuario:");
                    String nombreUsuario = scanner.nextLine();
                    System.out.println("Ingresa el tipo de usuario (Votante):");
                    String tipoUsuario = scanner.nextLine();
                    System.out.println("Ingresa la contraseña del usuario:");
                    String contrasenaUsuario = scanner.nextLine();
                    usuarios[numUsuariosRegistrados][0] = nombreUsuario;
                    usuarios[numUsuariosRegistrados][1] = tipoUsuario;
                    usuarios[numUsuariosRegistrados][2] = contrasenaUsuario;
                    numUsuariosRegistrados++;
                    System.out.println("Votante registrado con éxito.");
                    break;
                case 2:
                    System.out.println("Ingresa tu nombre de usuario:");
                    String nombreIngresado = scanner.nextLine();
                    System.out.println("Ingresa tu contraseña:");
                    String contrasenaIngresada = scanner.nextLine();
                    boolean usuarioEncontrado = false;
                    int indiceUsuario = -1;

                    for (int i = 0; i < numUsuariosRegistrados; i++) {
                        if (usuarios[i][0].equals(nombreIngresado) && usuarios[i][2].equals(contrasenaIngresada)) {
                            usuarioEncontrado = true;
                            indiceUsuario = i;
                            break;
                        }
                    }

                    if (usuarioEncontrado && usuarios[indiceUsuario][1].equals("Votante")) {
                        System.out.println("Iniciaste sesión como votante. Elige un candidato:");

                        for (int i = 0; i < candidatos.length; i++) {
                            System.out.println(i + 1 + ". " + candidatos[i]);
                        }

                        int voto = scanner.nextInt();
                        if (voto >= 1 && voto <= candidatos.length) {
                            votos[voto - 1]++;
                            System.out.println("Has emitido tu voto por " + candidatos[voto - 1] + ".");
                        } else {
                            System.out.println("Opción no válida. Voto no registrado.");
                        }
                    } else if (!usuarioEncontrado) {
                        System.out.println("Nombre de usuario o contraseña incorrectos.");
                    } else {
                        System.out.println("Este usuario no tiene permiso para votar.");
                    }
                    break;
                case 3:
                    System.out.println("Resultados de la votación:");
                    for (int i = 0; i < candidatos.length; i++) {
                        System.out.println(candidatos[i] + ": " + votos[i] + " votos");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}