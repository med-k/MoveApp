package vermeg.move.spring.service;
import java.util.List;
import vermeg.move.spring.entity.Passeport;

public interface PasseportService {
        public List<Passeport> getAllPasseport();
        public List<Passeport> getAllPasseportByCollaborateur(int id);
        public Passeport getPasseport(int id);
        public Passeport addPasseport(Passeport passeport);
        public Passeport editPasseport(Passeport passeport,int id);
        public void deletePasseportById(int id);
}
