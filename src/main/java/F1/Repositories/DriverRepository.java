package F1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import F1.Entities.Driver;
import java.util.List;
import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {
    public List<Driver> findAll();
    public Driver findDriverByRaceNumber(int raceNumber);

    @Query("SELECT d FROM Driver d WHERE d.currentTeam.name = :teamName")
    public List<Driver> findDriverByCurrentTeam_Name(@Param("teamName") String teamName);
}
