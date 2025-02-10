public class Cita {
    private String id;
    private String fechaHora;
    private String motivo;
    private String doctorId;
    private String pacienteId;

    public Cita(String id, String fechaHora, String motivo, String doctorId, String pacienteId) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.doctorId = doctorId;
        this.pacienteId = pacienteId;
    }

    public String getId() { return id; }
    public String getFechaHora() { return fechaHora; }
    public String getMotivo() { return motivo; }
    public String getDoctorId() { return doctorId; }
    public String getPacienteId() { return pacienteId; }

    @Override
    public String toString() {
        return id + "," + fechaHora + "," + motivo + "," + doctorId + "," + pacienteId;
    }
}