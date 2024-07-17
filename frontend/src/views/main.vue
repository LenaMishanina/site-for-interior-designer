<template>
    <div class="main_frame">

        <!-- БЛОК "НАВИГАЦИОННОЕ МЕНЮ" -->
        <div class="navigation_menu_top">
            <div class="logo_top" @click="forward('.main_frame', 150)">MILKOVA<br>PROJECT.RU</div>
            <div class="image_for_open_menu">
                <img @click="toggleMenu" src="../assets/images/menu.png" alt="">
            </div>
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
        <div :class="['nav_menu_for_mobile', { show: isMenuVisible }]">
                <div class="logo" @click="forward('.small_section_about_me_mobile', 200)">MILKOVA<br>PROJECT.RU</div>
                <div class="container_for_double_arrow">
                    <img @click="toggleMenu" class="double_arrow" src="../assets/images/double_arrow.png">
                </div>
                <ul class="list_of_blocks">
                    <li @click="secondForward('.calculate_prices', 100)">ЦЕНЫ</li>
                    <li @click="secondForward('.about_me_mobile', 100)">ОБО МНЕ</li>
                    <li @click="secondForward('.service_mobile', 70)">УСЛУГИ</li>
                    <li @click="secondForward('.stages_mobile', 100)">ЭТАПЫ</li>
                    <li @click="secondForward('.portfolio_mobile', 100)">ПОРТФОЛИО</li>
                    <li @click="secondForward('.request_mobile', 100)">ЗАЯВКА</li>
                    <li @click="secondForward('.bottom_mobile', 70)">КОНТАКТЫ</li>
                </ul>
                <div class="contacts_mobile">
                    <a href="https://instagram.com/alina_milkova_project"><img class="icon_instagram" src="../assets/images/inst_icon.png" alt=""></a>
                    <a href="tel:+79159849794"><img class="icon_telephone" src="../assets/images/telephone_icon.png" alt=""></a>
                    <a href="mailto:kalina-@mail.ru"><img class="icon_mail" src="../assets/images/mail_icon.png" alt=""></a>
                </div>
        </div>
        <!-- КОНЕЦ -->

        <!-- БЛОК "ТИТУЛЬНИК" -->
        <div class="small_section_about_me">
            <img class="first_photo" src="../assets/images/interior_photo.png" alt="">
            <div class="main_theme">
                <p class="main_text">Дизайн интерьера<br>в Ярославле</p>
                <button @click="forward('.request', 30)" class="button_for_get_consultation">Получить консультацию</button>
            </div>
            <div class="second_photo_and_text">
                <img class="second_photo" src="../assets/images/bedroom.png" alt="">
            </div>
        </div>
        <div class="small_section_about_me_mobile">
            <p class="main_text_mobile">Дизайн интерьера<br>в Ярославле</p>
            <button @click="forward('.request', 30)" class="button_for_get_consultation_mobile">Получить консультацию</button>
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
                        <div class="total_price">
                            <p class="price_container">От <span id="result-block1">96000</span> рублей</p>
                            <button @click="forward('.service_mobile', 80)" class="button_for_get_more">Подробнее</button>
                        </div>
                    </div>
                    <div class="output1">
                        <p class="text_inside_output">Планировочное решение</p>
                        <div class="total_price">
                            <p class="price_container">От <span id="result-block2">24000</span> рублей</p>
                            <button @click="forward('.service_mobile', 80)" class="button_for_get_more">Подробнее</button>
                        </div>
                    </div>
                </div>
        </div>
        <!-- КОНЕЦ -->

        <!-- РЕАЛИЗОВАТЬ БЛОК "ОБО МНЕ" -->
        <div class="about_me">
            <div class="photo_aliny_vitalevny2" style="position: relative; display: inline;">
                <img src="../assets/images/Component 2.png" alt="" style="position: relative; display: inline;">
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
        <div class="about_me_mobile">
            <div class="group_mobile">
                <div class="about_me_text_mobile">
                    Хотите получить уникальный дизайн<br>для своего дома или офиса?
                </div>
                <div>
                    <button @click="forward('.request', 30)" class="button_for_get_request_mobile">Получить консультацию</button>
                </div>
                <div class="container_for_photo_and_text_mobile">
                    <div class="photo_aliny_vitalevny2_mobile" style="position: relative; display: inline;">
                        <img src="../assets/images/Component 2.png" alt="" style="position: relative; display: inline; width:167px; height:217px; margin-top: 15px;">
                    </div>
                    <div class="light_about_me_text_mobile">Я поэтапно расскажу вам о том, как всё будет происходить от идеи до реализации.<br>Первая консультация не займет много времени.
                    </div>
                </div>
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
        <div class="my_advantages_mobile">
            <div class="title_advantages_mobile">МОИ ПРЕИМУЩЕСТВА</div>
            <div class="adv_container">
                <div class="step_advantage_mobile">
                    <img src="../assets/images/step1.png" alt="">
                    <div class="step_text_mobile">Проектирую более 12 лет</div>
                </div>
                <div class="step_advantage_mobile">
                    <img src="../assets/images/step2.png" alt="">
                    <div class="step_text_mobile">Я не завершу свою работу, пока вам не понравится результат</div>
                </div>
                <div class="step_advantage_mobile">
                    <img src="../assets/images/step3.png" alt="">
                    <div class="step_text_mobile">Закладываю в дизайн-проект только реальные товары, которые Вы легко найдете, отсканировав QR код</div>
                </div>
            </div>
            <div class="adv_container">
                <div class="step_advantage_mobile">
                    <img src="../assets/images/step4.png" alt="">
                    <div class="step_text_mobile">Создаю комфортное пространство для каждого члена семьи, учитывая его потребности</div>
                </div>
                <div class="step_advantage_mobile">
                    <img src="../assets/images/step5.png" alt="">
                    <div class="step_text_mobile">Даю подробное техническое задание для изготовления мебели</div>
                </div>
                <div class="step_advantage_mobile">
                    <img src="../assets/images/step6.png" alt="">
                    <div class="step_text_mobile">Отвечаю на вопросы по проекту даже после завершения сотрудничества</div>
                </div>
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
                    <div class="one_service">
                        <span class="nam_of_service" v-html="service.name"></span>
                        <span class="description_of_service" v-html="service.short_description"></span>
                        <div class="button_wrapper">
                            <span class="price_of_service" v-html="formatPrice(service)"></span>
                            <button v-if="service.name=='Полный<br>дизайн-проект'" class="button" @click="forward('.stages', 70)">Подробнее</button>
                            <button v-else-if="service.name=='Эскизный проект'" class="button" @click="openPdf">Подробнее</button>
                            <button v-else class="button" @click="showModal(service.name)">Подробнее</button>
                            <div v-if="modals[service.name]" @click.self="closeModal(service.name)" class="modal-shadow">
                                <div class="modal">
                                    <div class="modal_container">
                                      <span class="modal_text" v-html="service.long_description"></span>
                                    </div>
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
        
        <div class="service_mobile">
            <p class="title_mobile">УСЛУГИ ДИЗАЙНА</p>
            <div class="line_container_mobile">
                    <img src="../assets/images/Rectangle 165.png" class="line">
            </div>
            <div class="consultion_mobile" v-for="service in servic" :key="service.id">
                <div class="one_service_mobile">
                    <div class="nam_of_service_mobile" v-html="service.name"></div>
                    <div class="description_of_service_mobile" v-html="service.short_description"></div>
                    <div class="price_of_service_mobile" v-html="formatPrice(service)"></div>
                    <div class="button_mobile_wrapper">
                        <button v-if="service.name=='Полный<br>дизайн-проект'" class="button_mobile" @click="forward('.stages_mobile', 100)">Подробнее</button>
                        <button v-else-if="service.name=='Эскизный проект'" class="button_mobile" @click="openPdf">Подробнее</button>
                        <button v-else class="button_mobile" @click="showModal(service.name)">Подробнее</button>
                    </div>
                    <div v-if="modals[service.name]" @click.self="closeModal(service.name)" class="modal-shadow_mobile">
                        <div class="modal_container_mobile">
                            <span class="modal_text_mobile" v-html="service.long_description"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="line_container_mobile">
                <img src="../assets/images/Rectangle 165.png" class="line">
            </div>
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

                        <h6>Проектирование пространства</h6>
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
                            Процесс создания трехмерной модели пространства и передачи<br>его внешнего вида. Позволяет наглядно представить клиенту<br>конечный результат проекта до его реализации.
                        </p>
                        <img class="visualization_image" src="@/assets/images/vizualization.png" alt="">
                    </div>

                    <div class="work_documentation hidden" id="work_doc">
                        <h2 class="work_documentation_digital">4</h2>

                        <h6>Рабочая документация</h6>
                        <p class="work_documentation_text"> 
                            Полный комплект строительных чертежей согласно списку.
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

        <div class="stages_mobile">
            <div class="steps_work_mobile">ЭТАПЫ РАБОТЫ</div>
            <div v-for="(step, index) in steps" :key="index">
                <div class="one_step" v-if="index % 2 == 0">
                    <div class="digit_container_mobile">
                        <div class="digit_mobile">{{ index + 1 }}</div>
                    </div>
                    <div class="block_of_step_left_mobile">
                        <div class="name_of_step_mobile">{{ step.name }}</div>
                        <div class="description_of_step_mobile">{{ step.description }}</div>
                        <img class="img_mobile" :src="step.photo" alt="">
                    </div>
                </div>

                <div class="one_step" v-else>
                    <div class="block_of_step_right_mobile">
                        <div class="name_of_step_mobile">{{ step.name }}</div>
                        <div class="description_of_step_mobile">{{ step.description }}</div>
                        <img class="img_mobile" :src="step.photo" alt="">
                    </div>
                    <div class="digit_container_mobile">
                        <div class="digit_mobile">{{ index + 1 }}</div>
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
                    <div class="photos" v-for="image in portfolio" :key="image">  <!-- @click="openModal(image.index)" -->
                        <img :src="image.path" class="photo" @click="openModal(image.path)"> <!--  @mouseover="zoomIn" @mouseleave="zoomOut" -->
                    </div>
                
                    <div :class="['modal_photo', { show: isModalOpen }]" @click="togglePhoto">
                        <img class="modal-content" :src="currentImage">
                    </div>
                </div>
            </nav>
        </div>
        <div class="portfolio_mobile">
            <div class="text_mobile">ПОРТФОЛИО</div>
            <div class="line_container">
                <img src="../assets/images/Rectangle 165.png" class="line">
            </div>
            <div class="all_photos_mobile">
                <div class="photos_mobile" v-for="image in portfolio" :key="image">
                    <div class="photo-wrapper_mobile">
                        <img :src="image.path" class="photo_mobile">
                    </div>
                </div>
            </div>
        </div>
        <!-- КОНЕЦ -->

        <!-- БЛОК "ЗАЯВКА"-->
        <div class="request" id="request_id" >
            <div class="main_request">
                <div class="cl" id="main_reques">
                    <div class = "main_request_correct">
                        <h1>Заявка</h1>
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
                                    <div class="v_celect" id="v_celect" @click="areaOpsionsVisible = !areaOpsionsVisible">
                                        <img class="arrow_image" :src="areaOpsionsVisible ? '../src/assets/images/arrow_up.png' : '../src/assets/images/arrow.png'">
                                        <p class="titles" id="titles">
                                        {{ selected }}
                                        </p>
                                        <div class="options" v-if="areaOpsionsVisible">
                                            <p v-for="option in options" :key="option.value" @click="SelectOption(option)">
                                                {{ option.name }}
                                            </p>
                                        </div>
                                    </div>
                                    <label class="error_label_select" v-if="!areaOpsionsVisible">Выберите услугу</label>

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
        <div class="request_mobile">
            <div class = "main_request_correct">
                <h1>Заявка</h1>
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
                            <div class="v_celect" id="v_celect" @click="areaOpsionsVisible = !areaOpsionsVisible">
                                <div class="v_select_container">
                                    <p class="titles" id="titles" @click="areaOpsionsVisible = !areaOpsionsVisible">{{ selected }}</p>    
                                    <img class="arrow_image" :src="areaOpsionsVisible ? '../src/assets/images/arrow_up.png' : '../src/assets/images/arrow.png'"  @click="areaOpsionsVisible = !areaOpsionsVisible">
                                </div>
                                <div class="options" v-if="areaOpsionsVisible">
                                    <p class="option" v-for="option in options" :key="option.value" @click="SelectOption(option)">{{ option.name }}</p>
                                </div>
                            </div>
                            <label class="error_label_select" v-if="!areaOpsionsVisible" >Выберите услугу</label>
                        </div>
                        <div class="req_button_container">
                            <button type="submit" class="button_push_request" v-if="!iSvisible">Оставить заявку</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- КОНЕЦ -->
        <!-- БЛОК "НИЗ СТРАНИЦЫ" -->
        <div class="bottom">
            <div class="logo_bottom" @click="forward('.main_frame', 150)">MILKOVA<br>PROJECT.RU</div>
            <div class="navigation_menu_bottom">
                <button @click="forward('.calculate_prices', 150)" class="button_to_prices_bottom">ЦЕНЫ</button>
                <button @click="forward('.about_me', 140)" class="button_to_about_me_bottom">ОБО МНЕ</button>
                <button @click="forward('.service', 80)" class="button_to_services_bottom">УСЛУГИ</button>
                <button @click="forward('.stages', 80)" class="button_to_stages_bottom">ЭТАПЫ</button>
                <button @click="forward('.portfolio', 80)" class="button_to_portfolio_bottom">ПОРТФОЛИО</button>
                <button @click="forward('.request_mobile', 30)" class="button_to_request_bottom">ЗАЯВКА</button>
            </div>
            <div class="contacts">
                <p class="information">
                    Контакты:<br>
                    <img src="../assets/images/icon_mail.png" alt="" height="20" width="20"> kalina-@mail.ru<br>
                    <img src="../assets/images/icon_telephone.png" alt="" height="20" width="20"> +7-915-984-97-94<br>
                    <img src="../assets/images/icon_inst.png" alt="" height="20" width="20"> @alina_milkova_project
                </p>
            </div>
        </div>
        <div class="bottom_mobile">
            <div class="container_logo_and_menu">
                <div class="bottom_logo_mobile" @click="forward('.small_section_about_me_mobile', 200)">MILKOVA<br>PROJECT.RU</div>
                <div class="bottom_menu_mobile">
                    <p @click="forward('.calculate_prices', 100)">ЦЕНЫ</p>
                    <p @click="forward('.about_me_mobile', 100)">ОБО МНЕ</p>
                    <p @click="forward('.service_mobile', 70)">УСЛУГИ</p>
                    <p @click="forward('.stages_mobile', 100)">ЭТАПЫ</p>
                    <p @click="forward('.portfolio_mobile', 100)">ПОРТФОЛИО</p>
                    <p @click="forward('.request_mobile', 100)">ЗАЯВКА</p>
                </div>
            </div>
            <div class="contacts_bottom_mobile">
                <a href="https://instagram.com/alina_milkova_project"><img class="icon_instagram" src="../assets/images/inst_icon.png" alt=""></a>
                <a href="tel:+79159849794"><img class="icon_telephone" src="../assets/images/telephone_icon.png" alt=""></a>
                <a href="mailto:kalina-@mail.ru"><img class="icon_mail" src="../assets/images/mail_icon.png" alt=""></a>
            </div>
        </div>
        <!-- КОНЕЦ -->
    </div>
</template>




<script>
import {IMaskDirective} from 'vue-imask';


import technicalTaskImage from '@/assets/images/technical_task.png';
import projectFrameImage from '@/assets/images/project_frame.png';
import vizualizationImage from '@/assets/images/vizualization.png';
import workDocumentImage from '@/assets/images/work_document.png';
import complectationImage from '@/assets/images/complectation.png';

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
            isMenuVisible: false,
            isModalOpen: false,
            currentImage: null,
            steps: [
                { name: 'Техническое задание',
                  description: 'Это первая бесплатная встреча, на которой мы с вами знакомимся и обсуждаем предстоящую работу. Я рассказываю и показываю из чего состоит проект. Мы заключаем договор. Вы заполняете подробную анкету, которая будет являться техническим заданием на проектирование.', 
                  photo: technicalTaskImage},
                { name: 'Проектирование пространства',
                  description: 'После подписания договора я выполняю обмер помещения. На основании технического задания создается несколько вариантов планировок, после их обсуждения и внесения правок, мы выбираем вариант, максимально учитывающий все ваши пожелания.', 
                  photo: projectFrameImage},
                { name: 'Визуализация',
                  description: 'Процесс создания трехмерной модели пространства и передачи его внешнего вида. Позволяет наглядно представить клиенту конечный результат проекта до его реализации.', 
                  photo: vizualizationImage},
                { name: 'Рабочая документация',
                  description: 'Полный комплект строительных чертежей согласно списку.', 
                  photo: workDocumentImage},
                { name: 'Комплектация',
                  description: 'Конечный результат этапа комплектации представляет собой таблицу со ссылками на конкретные отделочные материалы, сантехнику, мебель и декор и указанием их стоимости. Так как таблица является редактируемым документом, Вы можете самостоятельно менять позиции и четко контролировать бюджет в процессе реализации дизайн-проекта.',
                  photo: complectationImage}
            ],
            options: [
                {name: 'Консультация', value:1},
                {name: 'Полный дизайн-проект', value:2},
                {name: 'Планировочное решение', value:3},
                {name: 'Эскизный проект', value:4},
                {name: 'Авторский надзор', value:5},
            ],
            servic: [],
            portfolio: [],
            backgroundStyle: {
                backgroundImage: `url(${new URL('@/assets/images/back_service.png', import.meta.url).href})`
            },        
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
        openModal(imagePath) {
            this.currentImage = imagePath;
            this.isModalOpen = true;
        },
        closeModal() {
            this.isModalOpen = false;
            this.currentImage = null;
        },
        openPdf() {
            const pdfPath = import.meta.env.VITE_APP_API_URL_PDF;
            window.open(pdfPath, '_blank');
        },
        secondForward(className, offset) {
            this.toggleMenu();
            this.forward(className, offset);
        },
        toggleMenu() { // Открытие навигационного меню на телефоне
            this.isMenuVisible = !this.isMenuVisible;
        },
        togglePhoto() { // Открытие фото при нажатии
            this.isModalOpen = !this.isModalOpen;
        },
        formatPrice(service) {
            return `${service.price} ${service.value_measure}`;
        },
        getServices(){
            fetch(import.meta.env.VITE_APP_API_URL_SERVICE)
            .then(res => res.json())
            .then(data => {
                this.servic = data
                // console.log(data)
            })
            },
        beforeMount() {
          this.getServices()
        },
        getPortfolio(){
            fetch(import.meta.env.VITE_APP_API_URL_PORTFOLIO)
            .then(res => res.json())
            .then(data => {
                this.portfolio = data
                // console.log(data)
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
            this.areaOpsionsVisible = true;
            this.selected = option.name;
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