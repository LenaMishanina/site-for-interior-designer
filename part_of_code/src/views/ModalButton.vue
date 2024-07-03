<template>
    <div class="main_frame">

        <!-- БЛОК "НАВИГАЦИОННОЕ МЕНЮ" -->
        <div class="navigation_menu_top">
            <div class="logo_top" @click="forward('.main_frame', 150)">MALINA<br>PROJECTS.RU</div>
            <div class="list_with_button_to_blocks_top">
                <button @click="forward('.calculate_prices', 150)" class="button_to_prices_top">ЦЕНЫ</button>
                <button @click="forward('.about_me', 140)" class="button_to_about_me_top">ОБО МНЕ</button>
                <button @click="forward('.service', 80)" class="button_to_services_top">УСЛУГИ</button>
                <button @click="forward('.stages', 80)" class="button_to_stages_top">ЭТАПЫ</button>
                <button @click="forward('.portfolio', 80)" class="button_to_portfolio_top">ПОРТФОЛИО</button>
                <button @click="forward('.request', 30)" class="button_to_request_top">ЗАЯВКА</button>
                <button @click="forward('.contacts', 0)" class="button_to_contacts_top">КОНТАКТЫ</button>
            </div>
        </div>
        <!-- КОНЕЦ -->

        <!-- БЛОК "ТИТУЛЬНИК" -->
        <div class="small_section_about_me">
            <img class="first_photo" src="@/assets/images/interior_photo.png" alt="">
            <div class="main_theme">
                <p class="main_text">Дизайн интерьера<br>в Ярославле</p>
                <button @click="forward('.request', 30)" class="button_for_get_consultation">Получить консультацию</button>
            </div>
            <div class="second_photo_and_text">
                <img class="second_photo" src="@/assets/images/photo_aliny_vitalevny1.png" alt="">
                <p class="text_on_photo_name">Алина Милкова</p>
                <p class="text_on_photo_profession">Дизайнер интерьера</p>
            </div>
        </div>
        <!-- КОНЕЦ -->

        <!-- РЕАЛИЗОВАТЬ БЛОК "ЦЕНЫ" -->
        <div class="calculate_prices">
            <p class="title_price">РАСЧЕТ ЦЕНЫ</p>
                <div class="counting_block">
                    <div class="slider_block">
                        <p class="calc_text">
                            Площадь помещения <span id="rangeValue"> 80</span> м²
                        </p> 
                        <input class="slider" type="range" min="15" max="300" value="80" oninput="rangeValue.innerText = this.value">
                    </div>
                    
                    <div class="output1">
                        <p class="text_inside_output">Полный дизайн-проект</p>
                        <p class="total_price">
                            От <span id="result-block1">96000</span> рублей
                            <button @click="forward('.service', 80)" class="button_for_get_more">Подробнее</button>
                        </p>
                    </div>
                    <div class="output2">
                        <p class="text_inside_output">Планировочное решение</p>
                        <p class="total_price">
                            От <span id="result-block2">24000</span> рублей
                            <button @click="forward('.service', 80)" class="button_for_get_more">Подробнее</button>
                        </p>
                    </div>
                </div>
        </div>
        <!-- КОНЕЦ -->

        <!-- РЕАЛИЗОВАТЬ БЛОК "ОБО МНЕ" -->
        <div class="about_me">
            <div class="photo_aliny_vitalevny2" style="position: relative; display: inline;">
                <img src="@/assets/images/photo_aliny_vitalevny2.png" alt="" style="position: relative; display: inline;">
            </div>
            <div class="about_me_text">
                Хотите получить уникальный дизайн<br>для своего дома или офиса?
                <div class="light_about_me_text">Я поэтапно расскажу вам о том как всё будет происходить<br>
                от идеи до реализации<br>
                Первая консультация не займет много времени
                </div>
                <button @click="forward('.request', 30)" class="button_for_get_request">Получить консультацию</button>
            </div>
        </div>
        <!-- КОНЕЦ -->

        <!-- РЕАЛИЗОВАТЬ БЛОК "МОИ ПРЕИМУЩЕСТВА" -->
        <div class="my_advantages">
            <div class="title_advantages">МОИ ПРЕИМУЩЕСТВА</div>
            <div class="step_advantage">
                <img src="@/assets/images/step1.png" alt="" style="position: relative; display: inline-block; width: 70px; height: 70px;">
                <div class="step_text">Проектирую более 12 лет</div>
            </div>
            <div class="step_advantage">
                <img src="@/assets/images/step2.png" alt="" style="position: relative; display: inline-block; width: 70px; height: 70px;">
                <div class="step_text">Я не завершу свою работу, пока вам не понравится результат</div>
            </div>
            <div class="step_advantage">
                <img src="@/assets/images/step3.png" alt="" style="position: relative; display: inline-block; width: 70px; height: 70px;">
                <div class="step_text">Закладываю в дизайн-проект только реальные товары, которые Вы легко найдете, отсканировав QR код</div>
            </div>
            <div class="step_advantage">
                <img src="@/assets/images/step4.png" alt="" style="position: relative; display: inline-block; width: 70px; height: 70px;">
                <div class="step_text">Создаю комфортное пространство для каждого члена семьи, учитывая его потребности</div>
            </div>
            <div class="step_advantage">
                <img src="@/assets/images/step5.png" alt="" style="position: relative; display: inline-block; width: 70px; height: 70px;">
                <div class="step_text">Даю подробное техническое задание для изготовления мебели</div>
            </div>
            <div class="step_advantage">
                <img src="@/assets/images/step6.png" alt="" style="position: relative; display: inline-block; width: 70px; height: 70px;">
                <div class="step_text">Отвечаю на вопросы по проекту даже после завершения сотрудничества</div>
            </div>
        </div>
        <!-- КОНЕЦ -->



        <!-- РЕАЛИЗОВАТЬ БЛОК "УСЛУГИ" -->
        <div class="service" :style="backgroundStyle">
            <nav class="nav_service">
                <p class="title">УСЛУГИ ДИЗАЙНА</p>
               
                <div class="consultion" v-for="service in servic" :key="service.id">

                    <div class="line_container">
                        <img src="@/assets/images/line.png" class="line">
                    </div>
                    <span class="nam_of_service">{{service.name}}</span>
                    <span class="description_of_service">{{service.short_description}}</span>
                    <div class="button_wrapper">
                        <span class="price_of_service">{{service.price}} {{service.value_measure}}</span>
                        <button class="button" @click="showModal(service.name)">Подробнее</button>
                        <div v-if="modals[service.name]" @click.self="closeModal(service.name)" class="modal-shadow">
                            <div class="modal">
                                <div class="modal_container">
                                    <span class="modal_text">{{service.long_description}}</span>
                                </div>
                            </div>
                        </div>
                    </div>
       
                </div>
                <div class="line_container">
                    <img src="@/assets/images/line.png" class="line">
                </div>

            </nav>
        </div>

        <!-- КОНЕЦ -->

        <!-- РЕАЛИЗОВАТЬ БЛОК "ЭТАПЫ" -->
        <div class="stages">
            <div class="global_frame">
                <div class="main_frame_stages">
                    <h1 class="steps_work">ЭТАПЫ РАБОТЫ</h1>

                    <div class="technical_task hidden" id="tech_task">
                        <h2 class="technical_task_digital">1</h2>

                        <h6>Техническое задание</h6>
                        <p class="technical_task_text">Это первая бесплатная встреча, на которой мы с<br>
                             вами знакомимся и обсуждаем предстоящую работу.<br>
                             Я рассказываю и показываю из чего состоит проект.<br>
                             Мы заключаем договор. Вы заполняете подробную<br>
                             анкету, которая будет являться техническим<br>
                             заданием на проектирование.
                        </p>
                        <img class="technical_task_image" src="@/assets/images/technical_task.png" alt="">
                    </div>

                    <div class="project_frame hidden" id="poject_fr">
                        <h2 class="project_frame_digital">2</h2>

                        <h6>Проектирование пространтва</h6>
                        <p class="project_frame_text">
                             После подписания договора я выполняю обмер<br>
                             помещения. На основании технического <br>
                             задания создается несколько вариантов <br>
                             планировок, после их обсуждения и внесения<br>
                             правок, мы выбираем вариант, максимально<br>
                             учитывающий все ваши пожелания.
                        </p>
                        <img class="project_frame_image" src="@/assets/images/project_frame.png" alt="">
                    </div>

                    <div class="visualization hidden" id="visual">
                        <h2 class="visualization_digital">3</h2>

                        <h6>Визуализация</h6>
                        <p class="visualization_text">
                            Процесс создания трехмерной модели пространства и передачи<br>его внешнего вида. Позволяет наглядно представить клиенту<br>конечный результат проекта до его реализации
                        </p>
                        <img class="visualization_image" src="@/assets/images/vizualization.png" alt="">
                    </div>

                    <div class="work_documentation hidden" id="work_doc">
                        <h2 class="work_documentation_digital">4</h2>

                        <h6>Рабочая документация</h6>
                        <p class="work_documentation_text"> 
                            Полный комплект строительных чертежей согласно списку
                        </p>
                        <img class="work_documentation_image" src="@/assets/images/work_document.png" alt="">
                    </div>

                    <div class="complectation hidden" id="complect">
                        <h2 class="complectation_digital">5</h2>

                        <h6>Комплектация</h6>
                        <p class="complectation_text">
                            Конечный результат этапа комплектации <br>
                             представляет собой таблицу со ссылками на<br>
                             конкретные отделочные материалы, сантехнику,<br>
                             мебель и декор и указанием их стоимости.Так как<br>
                             таблица является редактируемым документом, Вы<br>
                             можете самостоятельно менять позиции и четко<br>
                             контролировать бюджет в процессе реализации<br>
                             дизайн-проекта.
                        </p>
                        <img class="complectation_image" src="@/assets/images/complectation.png" alt="">
                    </div>
                </div>
            </div>
        </div>
        <!-- КОНЕЦ -->





        <!-- РЕАЛИЗОВАТЬ БЛОК "ПОРТФОЛИО" -->
        <div class="portfolio">
            <nav>
                <p class="title">ПОРТФОЛИО</p>

                <div class="line_container">
                    <img src="@/assets/images/line.png" class="line">
                </div>
                <div class="gallery">
                    <div class="photos" v-for="image in portfolio" :key="image" @click="openModal(image.index)">
                        <img :src="image.path" class="zoom-image" @mouseover="zoomIn" @mouseleave="zoomOut">
                    </div>
                

                    <!-- Модальное окно для отображения фото -->
                    <div v-if="modalImage !== null" class="modal_window" @click="closeModal_img">
                        <!-- <img :src="modalImage.url" class="modal-image"> -->
                        <img :src="modalImage.path" class="modal-image">
                    </div>
                </div>
            </nav>
        </div>
        <!-- КОНЕЦ -->



        <!-- БЛОК "ЗАЯВКА"-->
        <div class="request" id="request_id" >
            <div class="main_request">
                <div class="cl" id="main_reques">
                    <div class = "main_request_correct">
                        <h1>Оставить заявку</h1>
                        <div class="for_inputs">
                            <!--onsubmit="submitForm(event)"-->
                            <form action=""  class="form" id="add_form" >
                                <div class="name_config">
                                    <p class="your_name">Ваше имя:</p>
                                    <input type="text" id="name" name="name" class="name_contact" placeholder="Имя" autocomplete="off">
                                    <label class="error_label">Введите имя</label>
                                </div>
                                <div class="number_config">
                                    <p class="numper_phone">Номер телефона:</p>
                                    <input type="phone" name="name" id="phone" class="name_contact" v-imask="phoneNumberMask" @keypress="isNumber" placeholder="+7 (***) ***-**-**" autocomplete="off">
                                    <label class="error_label">Введите номер телефона</label>
                                    
                                </div>
                                <div class="celect_config">
                                    <p class="celect_service">Выбрать услугу:</p>
                                    <div class="v_celect" id="v_celect" @click="areaOpsionsVisible = !areaOpsionsVisible"  >
                                        <img class="arrow_image" :src="areaOpsionsVisible ? '../src/assets/images/arrow_up.png' : '../src/assets/images/arrow.png'"  @click="areaOpsionsVisible = !areaOpsionsVisible">
                                        <p class="titles" id="titles">
                                        {{ selected }}
                                        </p>
                                        <div class="options" v-if="areaOpsionsVisible">
                                            <p v-for="option in options" :key="option.value" @click="SelectOption(option)">
                                                {{ option.name }}
                                            </p>
                                        </div>
                                    </div>
                                    <label class="error_label_select" v-if="!areaOpsionsVisible" >Выберите услугу</label>

                                </div>

                                <button type="submit" class="button_push_request" v-if="!iSvisible">Оставить заявку</button>

                            </form>
                        </div>
                            
                    </div>
                </div>
                <h1 class="text_price">УЗНАТЬ ТОЧНУЮ СТОИМОСТЬ<br> И ВСЕ ДЕТАЛИ ПО ДИЗАЙН-ПРОЕКТУ</h1>
                
                <h2 class="more_information">Оставьте заявку и я свяжусь с<br>
                                            вами, чтобы обсудить все интересующие<br>
                                            вас вопросы</h2>
                <div class="create-line"></div>
                <hr>
                <div class="for_background">
                    <img class="request_background_photo" @click.self="areaOpsionsVisible = false" src="@/assets/images/photo_laptop_b.png">
                </div>
            </div>
        </div>
        <!-- КОНЕЦ -->
        <!-- БЛОК "НИЗ СТРАНИЦЫ" -->
        <div class="bottom">
            <div class="logo_bottom" @click="forward('.main_frame', 150)">MALINA<br>PROJECTS.RU</div>
            <div class="navigation_menu_bottom">
                <button @click="forward('.calculate_prices', 150)" class="button_to_prices_bottom">ЦЕНЫ</button>
                <button @click="forward('.about_me', 140)" class="button_to_about_me_bottom">ОБО МНЕ</button>
                <button @click="forward('.service', 80)" class="button_to_services_bottom">УСЛУГИ</button>
                <button @click="forward('.stages', 80)" class="button_to_stages_bottom">ЭТАПЫ</button>
                <button @click="forward('.portfolio', 80)" class="button_to_portfolio_bottom">ПОРТФОЛИО</button>
                <button @click="forward('.request', 30)" class="button_to_request_bottom">ЗАЯВКА</button>
            </div>
            <div class="contacts">
                <p class="information">
                    Контакты:<br>
                    milkova.alina@mail.ru<br>
                    +7-912-271-65-25<br>
                    <span class="bullet"></span> Пн-Пт с 8:00-19:00
                </p>
            </div>
        </div>
        <!-- КОНЕЦ -->
    </div>
</template>




<script>
import {IMaskDirective} from 'vue-imask';

const imagesContext = import.meta.glob('@/assets/images/project1/*');

const images = Object.keys(imagesContext).map(key => imagesContext[key]);



export default {
    props: {
        // selected: {
        //     type: String,
        //     default: ''
        // }
    },
    name: "ModalButton",
    name_b: "V_celect",
    data() {
        return {
            servic: [],
            portfolio: [],
            backgroundStyle: {
                backgroundImage: `url(${new URL('@/assets/images/back_service.png', import.meta.url).href})`
            },        
            modalImage: null,
            modals: {
                consultation: false,
                designProject: false,
                planDecision: false,
                sketchyProject: false,
                authorsProject: false
            },
            pdfUrl: '../public/Mini-design_project_to_define_cost.pdf',

            selected: 'Услуга',
            areaOpsionsVisible : false,
            iSvisible : false,
            phoneNumberMask: {
                mask: '+7 (***) ***-**-**',
                lazy: true
            }

        };
    },
    methods: {
        getServices(){
                fetch('http://localhost:8080/service')
                .then(res => res.json())
                .then(data => {
                    this.servic = data
                    console.log(data)
                })
            },
        beforeMount() {
          this.getServices()
        },
        getPortfolio(){
            fetch('http://localhost:8080/portfolio')
            .then(res => res.json())
            .then(data => {
                this.portfolio = data
                console.log(data)
            })
        },

        // Функция прокрутки веб-страницы до определенного класса (className) при нажатии на какую-либо кнопку в навигации
        forward(className, offset) {
            const element = document.querySelector(className);
            const topPos = element.getBoundingClientRect().top + window.pageYOffset - offset;
            window.scrollTo({ top: topPos, behavior: 'smooth' });
        },
        //КОНЕЦ 

        //Функции открытия и закрытия модального окна в услугах
        showModal(modal) {
            this.modals[modal] = true;
        },
        closeModal(modal) {
            this.modals[modal] = false;
        },
        
        // КОНЕЦ
        //Ф-ции открытия и закрытия окна с фоткой в портфолио
        openModal(index) {
            this.modalImage = this.portfolio[index];
            document.querySelectorAll('.zoom-image').forEach(image => {
                image.style.transform = 'none';
            });
        },
        closeModal_img() {
            this.modalImage = null;
        },//КОНЕЦ
        //Ф-ции при наведении курсора
        zoomIn(event) {
            event.currentTarget.style.transform = 'scale(1.1)';
        },
        zoomOut(event) {
            event.currentTarget.style.transform = 'scale(1)';
        },
        
        SelectOption(option) {
            this.selected = option.name
            areaOpsionsVisible =!this.areaOpsionsVisible;
        },
        isNumber(e) {
            let regex = /[0-9]/
            if (!regex.test(e.key)) {
                e.returnValue = false;
                if (e.preventDefault) e.preventDefault();
            }
        }

        //КОНЕЦ

    },
    
    mounted() {
        this.getServices();
        this.getPortfolio();
        document.querySelector('.slider').addEventListener('input', function() {
            let value = this.value;
            document.querySelector('#result-block1').innerText = value * 1200;
            document.querySelector('#result-block2').innerText = value * 300;
        });

        // Валидация для заявки


        // Удаление после успешной отправки заявки
        function clearRequest(form) {
            const allInputs = form.querySelectorAll('input');
            const titlesElement = document.querySelector('.titles');
            const selectedValue = titlesElement.textContent;

            for (const input of allInputs) {
                input.value = "";
            }
            titlesElement.textContent = "Услуга";
        }

        // Валидация 
        function validation(form) {

            function removeErroSelect(element) {
                const parent_child = element.parentNode;
                const parent = parent_child.parentNode;
                if (parent.classList.contains('error')) {
                    parent.classList.remove('error')
                }
            }
            function removeForInputError(input) {
                const parent = input.parentNode;
                if (parent.classList.contains('error')) {
                    parent.classList.remove('error')
                }
            }
            function createForInputError(input, text) {
                const parent = input.parentNode;
                parent.classList.add('error')
            }

            function createErrorForSelected(element, text) {
                const parent = element.parentNode;
                const parent_parent = parent.parentNode;
                parent_parent.classList.add('error');

            }

            let result = true;
            const allInputs = form.querySelectorAll('input');
            const titlesElement = document.querySelector('.titles');
            const selectedValue = titlesElement.textContent;

            removeErroSelect(titlesElement)
            if (selectedValue == 'Услуга') {
                createErrorForSelected(titlesElement,'You need push text in line' )
                result = false;
            }
            for (const input of allInputs) {
                removeForInputError(input)
                if (input.id === 'phone' && input.value.length < 18)  {
                    createForInputError(input, 'You need to enter text in this field');
                    console.log('PEDRO');
                    result = false;
                } else if (input.id === 'name' && input.value === "") {
                    console.log('Error');
                    createForInputError(input, 'You need to enter text in this field');
                    result = false;
                }

                console.log(input);
            }
            return result
        }

        // Обработчик заявки
        document.getElementById('add_form').addEventListener('submit',function(event){
            event.preventDefault();

            if(validation(this) == true) {
                //submitForm(event);
                Email.send({
                  Host : "smtp.elasticemail.com",
                  Username : "vdass3532@gmail.com",
                  Password : "3503A72CFB3FCE463A623A4FDDF57304B1BC",
                  To : "vdass3532@gmail.com",
                  From : "vdass3532@gmail.com",
                  Subject : "Заявка с сайта",
                Body:  document.getElementById('name').value + '\n' + document.getElementById('phone').value + '\n' + document.getElementById('titles').textContent
              }).then(
                message => alert(message)
              );
              clearRequest(this);

  
              return true;
                //alert('Заявка успешно отправлена!')
            }
        })

        window.addEventListener('scroll', function() {
            var elementIds = ['tech_task', 'poject_fr', 'visual', 'work_doc', 'complect', 'main_reques'];

            elementIds.forEach(function(id) {
                var element = document.getElementById(id);
                if (element) {
                    var elementPosition = element.getBoundingClientRect().top;
                    if (elementPosition < window.innerHeight) {
                        element.classList.add('show');
                    } else {
                        element.classList.remove('show');
                    }
                }
            });
        });

    },
    
    directives: {
        imask: IMaskDirective
    }

    // КОНЕЦ
}

</script>
<style>

</style>