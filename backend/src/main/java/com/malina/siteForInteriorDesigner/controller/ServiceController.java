package com.malina.siteForInteriorDesigner.controller;

import com.malina.siteForInteriorDesigner.entity.ServiceEntity;
import com.malina.siteForInteriorDesigner.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ServiceController {
    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }
    @GetMapping("/service")
    public List<ServiceEntity> findAllService() {
        ServiceEntity ser1 = new ServiceEntity(
                Long.valueOf(1),
                "Консультация",
                "Это может быть онлайн или живая встреча",
                "Это может быть онлайн или живая встреча. Стоимость – от 1000 рублей в зависимости от задачи и времени ее решения.",
                Long.valueOf(1500),
                "руб"
        );
        ServiceEntity ser2 = new ServiceEntity(
                Long.valueOf(2),
                "Полный дизайн-проект",
                "Предоставление полного дизайн-проекта для интерьера, включая все необходимые планы, спецификации и таблицы для реализации проекта.",
                "some22",
                Long.valueOf(1800),
                "руб/м"
        );
        ServiceEntity ser3 = new ServiceEntity(
                Long.valueOf(3),
                "Планировочное решение",
                "Создание полного плана интерьера",
                "Услуга создания планировочного решения включает: " +
                        "- Обмерный чертеж с отображением и привязками всех существующих конструкций и коммуникаций;" +
                        "- План демонтажа существующих перегородок;" +
                        "- План монтажа новых перегородок;" +
                        "- План помещения после перепланировки с экспликацией;" +
                        "- План расстановки мебели;",
                Long.valueOf(300),
                "руб/м"
        );
        ServiceEntity ser4 = new ServiceEntity(
                Long.valueOf(4),
                "Эскизный проект",
                "Это мини-проект, адаптированный под Вашу задачу.",
                "Это мини-проект, адаптированный под Вашу задачу. Смотреть пример",
                Long.valueOf(5000),
                "руб/пом"
        );
        ServiceEntity ser5 = new ServiceEntity(
                Long.valueOf(5),
                "Авторский надзор",
                "Помощь и контроль в процессе реализации дизайн-проекта.",
                "Данная услуга предполагает:" +
                        "- регулярный выезд на объект с целью обсуждения с подрядчиком вопросов, возникающих в процессе реализации дизайн-проекта;" +
                        "- консультирование онлайн и по телефону;" +
                        "- помощь в подборе отделочных и декоративных материалов, поиск аналогов;" +
                        "- контроль графика поставок и приемка материалов.",
                Long.valueOf(7000),
                "руб/мес"
        );
//        return Arrays.asList(ser1, ser2, ser3, ser4, ser5);
        return service.findAllService();
    }
    @PostMapping("/service/add")
    public String addService(@RequestBody ServiceEntity ser) {
        service.addService(ser);
        return "Service was added successfully...";
    }
    @GetMapping("/service/{id}")
    public ServiceEntity getServiceById(@PathVariable("id") long id){
        return service.findServiceById(id);
    }
    @PutMapping("/service")
    public ServiceEntity updateService(@RequestBody ServiceEntity ser) {
        return service.updateService(ser);
    }
    @DeleteMapping("/service/{id}")
    public String deleteService(@PathVariable("id") long id){
        service.deleteService(id);
        return "Service was removed successfully...";
    }

}
