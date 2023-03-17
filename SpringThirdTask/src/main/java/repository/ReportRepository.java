package repository;

import model.Report;
import model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    Report getReportByName(String name);

    List<Report> findAllById(List<Integer> ids);

    Page<Report> findAll(Pageable pageable);


    @Query(value = "select r from Report r where r.id in :ids")
    List<Report> findAllByIds(@Param("ids") List<Integer> ids);

    @Query(value = "select r from Report r where r.name = :name and r.id = :id")
    User findReportByNameAndId(@Param("name") String name, @Param("id") Integer id);

}
