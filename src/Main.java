import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaCitas sistema = new SistemaCitas();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Sistema de Citas Médicas");
        System.out.print("Ingrese su ID de administrador: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (sistema.autenticarAdministrador(id, contrasena)) {
            System.out.println("Autenticación exitosa.");
            mostrarMenu(sistema, scanner);
        } else {
            System.out.println("Autenticación fallida.");
        }
    }

    private static void mostrarMenu(SistemaCitas sistema, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Dar de alta doctor");
            System.out.println("2. Dar de alta paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Ver doctores");
            System.out.println("5. Ver pacientes");
            System.out.println("6. Ver citas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    altaDoctor(sistema, scanner);
                    break;
                case 2:
                    altaPaciente(sistema, scanner);
                    break;
                case 3:
                    crearCita(sistema, scanner);
                    break;
                case 4:
                    verDoctores(sistema);
                    break;
                case 5:
                    verPacientes(sistema);
                    break;
                case 6:
                    verCitas(sistema);
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void altaDoctor(SistemaCitas sistema, Scanner scanner) {
        System.out.print("Ingrese el ID del doctor: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre completo del doctor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la especialidad del doctor: ");
        String especialidad = scanner.nextLine();
        sistema.altaDoctor(new Doctor(id, nombre, especialidad));
        System.out.println("Doctor registrado exitosamente.");
    }

    private static void altaPaciente(SistemaCitas sistema, Scanner scanner) {
        System.out.print("Ingrese el ID del paciente: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre completo del paciente: ");
        String nombre = scanner.nextLine();
        sistema.altaPaciente(new Paciente(id, nombre));
        System.out.println("Paciente registrado exitosamente.");
    }

    private static void crearCita(SistemaCitas sistema, Scanner scanner) {
        System.out.print("Ingrese el ID de la cita: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese la fecha y hora de la cita (formato: dd/MM/yyyy HH:mm): ");
        String fechaHora = scanner.nextLine();
        System.out.print("Ingrese el motivo de la cita: ");
        String motivo = scanner.nextLine();
        System.out.print("Ingrese el ID del doctor: ");
        String doctorId = scanner.nextLine();
        System.out.print("Ingrese el ID del paciente: ");
        String pacienteId = scanner.nextLine();
        sistema.crearCita(new Cita(id, fechaHora, motivo, doctorId, pacienteId));
        System.out.println("Cita creada exitosamente.");
    }

    private static void verDoctores(SistemaCitas sistema) {
        System.out.println("\n--- Lista de Doctores ---");
        for (Doctor doctor : sistema.getDoctores()) {
            System.out.println("ID: " + doctor.getId() + ", Nombre: " + doctor.getNombreCompleto() + ", Especialidad: " + doctor.getEspecialidad());
        }
    }

    private static void verPacientes(SistemaCitas sistema) {
        System.out.println("\n--- Lista de Pacientes ---");
        for (Paciente paciente : sistema.getPacientes()) {
            System.out.println("ID: " + paciente.getId() + ", Nombre: " + paciente.getNombreCompleto());
        }
    }

    private static void verCitas(SistemaCitas sistema) {
        System.out.println("\n--- Lista de Citas ---");
        for (Cita cita : sistema.getCitas()) {
            System.out.println("ID: " + cita.getId() + ", Fecha y Hora: " + cita.getFechaHora() + ", Motivo: " + cita.getMotivo() + ", Doctor ID: " + cita.getDoctorId() + ", Paciente ID: " + cita.getPacienteId());
        }
    }
}