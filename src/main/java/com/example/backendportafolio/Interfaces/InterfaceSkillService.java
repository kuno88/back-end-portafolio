package com.example.backendportafolio.Interfaces;



import com.example.backendportafolio.Models.SkillModel;
import java.util.List;

public interface InterfaceSkillService {

    public List<SkillModel> get();
    public void save(SkillModel skill);
    public void delete(Long id);
    public SkillModel find(Long id);
}
