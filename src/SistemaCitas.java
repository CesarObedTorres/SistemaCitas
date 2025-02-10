import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaCitas {
    private List<Doctor> doctores;
    private List<Paciente> pacientes;
    private List<Cita> citas;
    private List<Administrador> administradores;

    public SistemaCitas() {
        doctores = new ArrayList<>();
        pacientes = new ArrayList<>();
        citas = new ArrayList<>();
        administradores = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos() {
        cargarDoctores();
        cargarPacientes();
        cargarCitas();
        cargarAdministradores();
    }

    private void cargarDoctores() {
        File archivo = new File("db/doctores.csv");
        if (!archivo.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                bw.write("doc1,Juan Pérez,Cardiología");
                bw.newLine();
                System.out.println("Archivo doctores.csv creado exitosamente en la carpeta db.");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de doctores: " + e.getMessage());
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                doctores.add(new Doctor(datos[0], datos[1], datos[2]));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar doctores: " + e.getMessage());
        }
    }

    private void cargarPacientes() {
        File archivo = new File("db/pacientes.csv");
        if (!archivo.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                bw.write("pac1,Maria López");
                bw.newLine();
                System.out.println("Archivo pacientes.csv creado exitosamente en la carpeta db.");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de pacientes: " + e.getMessage());
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                pacientes.add(new Paciente(datos[0], datos[1]));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar pacientes: " + e.getMessage());
        }
    }

    private void cargarCitas() {
        File archivo = new File("db/citas.csv");
        if (!archivo.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                bw.write("cit1,2023-10-15 10:00,Consulta general,doc1,pac1");
                bw.newLine();
                System.out.println("Archivo citas.csv creado exitosamente en la carpeta db.");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de citas: " + e.getMessage());
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                citas.add(new Cita(datos[0], datos[1], datos[2], datos[3], datos[4]));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar citas: " + e.getMessage());
        }
    }

    private void cargarAdministradores() {
        File archivo = new File("db/administradores.csv");
        if (!archivo.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                bw.write("admin,admin123");
                bw.newLine();
                System.out.println("Archivo administradores.csv creado exitosamente en la carpeta db.");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de administradores: " + e.getMessage());
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                administradores.add(new Administrador(datos[0], datos[1]));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar administradores: " + e.getMessage());
        }
    }

    public void altaDoctor(Doctor doctor) {
        doctores.add(doctor);
        guardarDoctores();
    }

    public void altaPaciente(Paciente paciente) {
        pacientes.add(paciente);
        guardarPacientes();
    }

    public void crearCita(Cita cita) {
        citas.add(cita);
        guardarCitas();
    }

    public boolean autenticarAdministrador(String id, String contrasena) {
        for (Administrador admin : administradores) {
            if (admin.getId().equals(id) && admin.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    private void guardarDoctores() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("db/doctores.csv"))) {
            for (Doctor doctor : doctores) {
                bw.write(doctor.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar doctores: " + e.getMessage());
        }
    }

    private void guardarPacientes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("db/pacientes.csv"))) {
            for (Paciente paciente : pacientes) {
                bw.write(paciente.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar pacientes: " + e.getMessage());
        }
    }

    private void guardarCitas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("db/citas.csv"))) {
            for (Cita cita : citas) {
                bw.write(cita.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar citas: " + e.getMessage());
        }
    }

    private void guardarAdministradores() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("db/administradores.csv"))) {
            for (Administrador admin : administradores) {
                bw.write(admin.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar administradores: " + e.getMessage());
        }
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Cita> getCitas() {
        return citas;
    }
}