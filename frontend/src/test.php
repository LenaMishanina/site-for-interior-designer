<?php
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\SMTP;
use PHPMailer\PHPMailer\Exception;

require 'PHPMailer/PHPMailer/src/Exception.php';
require 'PHPMailer/PHPMailer/src/PHPMailer.php';
require 'PHPMailer/PHPMailer/src/SMTP.php';

$mail = new PHPMailer(true);
    try {
		$mail->isMail();
        $mail->SMTPDebug = SMTP::DEBUG_SERVER;
        $mail->isSMTP();
        $mail->Host       = 'smtp.gmail.com';
        $mail->SMTPAuth   = true;
        $mail->Username   = 'vdass3532@gmail.com';
        $mail->Password   = 'gdqf hipf xxdf bvyb';
        $mail->SMTPSecure = 'ssl';
        $mail->Port       = 465;
        $mail->CharSet    = 'UTF-8';
        
        $mail->setFrom('vdass3532@gmail.com', 'vdass3532@gmail.com');
        $mail->addAddress('vdass3532@gmail.com');
        $body = '<p>Name: '.$_POST['name'].'</p>' . '<p>Number phone: '.$_POST['number_phone'];
        $mail->isHtml(true);
        $mail->Subject = 'Message';
        $mail->Body = $body;
        $mail->send();
        echo 'Message has been sent';
    } catch (Exception $e) {
        echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
    }
?>