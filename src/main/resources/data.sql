
-- Insertar datos de prueba para ElderlyUser
INSERT INTO elderly_user ( name, email, phone) VALUES
('Juan Pérez', 'juanperez@example.com', '123-456-7890'),
('María García', 'mariagarcia@example.com', '234-567-8901'),
('Roberto Fernández', 'robertof@example.com', '345-678-9012'),
('Ana López', 'analopez@example.com', '456-789-0123'),
('Miguel Rodríguez', 'miguelr@example.com', '567-890-1234'),
('Sofía Sánchez', 'sofias@example.com', '678-901-2345'),
('David Martín', 'davidm@example.com', '789-012-3456'),
('Laura Jiménez', 'lauraj@example.com', '890-123-4567'),
('Javier Díaz', 'javierd@example.com', '901-234-5678'),
('Elena Torres', 'elenat@example.com', '012-345-6789');

-- Insertar datos de prueba para Companion
INSERT INTO companion ( name, age, email, description, photo_url, hourly_rate, rating) VALUES
('Alicia Gómez', 30, 'juanperez@example.com', 'Amable y con experiencia.', 'https://example.com/photo1.jpg', 20.0, 4.8),
('Carlos Ruiz', 40, 'mariagarcia@example.com', 'Le encantan las actividades al aire libre.', 'https://example.com/photo2.jpg', 18.0, 4.7),
('Luis Torres', 35, 'robertof@example.com', 'Experto en juegos de mesa.', 'https://example.com/photo3.jpg', 22.0, 4.9),
('Diana Herrera', 32, 'analopez@example.com', 'Disfruta de los museos y la historia.', 'https://example.com/photo4.jpg', 19.5, 4.6),
('Esteban Castro', 45, 'miguelr@example.com', 'Gran contador de historias.', 'https://example.com/photo5.jpg', 21.0, 4.5),
('Fernanda Ríos', 29, 'sofias@example.com', 'Apasionada por la música.', 'https://example.com/photo6.jpg', 20.5, 4.9),
('Gabriel Vargas', 50, 'davidm@example.com', 'Le encanta cocinar en compañía.', 'https://example.com/photo7.jpg', 23.0, 4.7),
('Helena Castillo', 28, 'lauraj@example.com', 'Creativa y artística.', 'https://example.com/photo8.jpg', 18.5, 4.6),
('Ignacio Peña', 37, 'javierd@example.com', 'Exprofesor, le encantan las discusiones.', 'https://example.com/photo9.jpg', 19.0, 4.8),
('Julia Morales', 34, 'elenat@example.com', 'Activa y enérgica.', 'https://example.com/photo10.jpg', 22.5, 4.7);

-- Insertar datos de prueba para Activity
INSERT INTO activity ( name, description) VALUES
('Caminata', 'Un paseo relajante en el parque.'),
('Juegos de mesa', 'Jugando ajedrez y otros juegos.'),
('Visita al museo', 'Explorando museos históricos.'),
('Concierto', 'Disfrutando de espectáculos en vivo.'),
('Cocina', 'Cocinando juntos y compartiendo recetas.'),
('Teatro', 'Viendo presentaciones en vivo.'),
('Lectura en la biblioteca', 'Leyendo y discutiendo libros.'),
('Yoga', 'Ejercicios de estiramiento y relajación.'),
('Fotografía', 'Explorando técnicas de fotografía.'),
('Pintura', 'Creando obras de arte y aprendiendo técnicas.');

-- Insertar datos de prueba para Review
INSERT INTO review ( stars, comment, elderly_user_id, companion_id) VALUES
( 5, 'Alicia fue increíble!', 1, 1),
( 4, 'Carlos fue muy servicial.', 2, 2),
( 5, 'Luis conoce todos los juegos de mesa!', 3, 3),
( 5, 'Diana sabe mucho sobre historia.', 4, 4),
( 4, 'Esteban contó historias fascinantes.', 5, 5),
( 5, 'Fernanda fue una excelente compañera.', 6, 6),
( 4, 'Gabriel hizo que cocinar fuera divertido.', 7, 7),
( 5, 'Helena es muy talentosa en arte.', 8, 8),
( 5, 'Ignacio es un gran maestro.', 9, 9),
( 4, 'Julia tiene mucha energía.', 10, 10);

-- Insertar datos de prueba para Notification
INSERT INTO notification ( message, timestamp, companion_id) VALUES
('Tienes una nueva solicitud de contacto.', '2025-03-18 10:00:00', 1),
('Se ha publicado una nueva reseña.', '2025-03-18 10:05:00', 2),
('Alguien ha visto tu perfil.', '2025-03-18 10:10:00', 3),
('Tienes una nueva solicitud de reserva.', '2025-03-18 10:15:00', 4),
('Un usuario te ha enviado un mensaje.', '2025-03-18 10:20:00', 5),
('¡Tu calificación ha aumentado!', '2025-03-18 10:25:00', 6),
('Un nuevo usuario está interesado en tus servicios.', '2025-03-18 10:30:00', 7),
('Recordatorio: Sesión mañana a las 9 AM.', '2025-03-18 10:35:00', 8),
('Tu disponibilidad ha sido actualizada.', '2025-03-18 10:40:00', 9),
('¡Felicidades! Has recibido una calificación de 5 estrellas.', '2025-03-18 10:45:00', 10);

-- Insertar datos de prueba para ContactRequest
INSERT INTO contact_request ( elderly_user_id, companion_id, message, requested_date) VALUES
(1, 1, 'Me gustaría dar un paseo contigo.', '2025-03-19 09:00:00'),
(2, 2, '¿Podemos jugar al ajedrez juntos?', '2025-03-19 10:00:00'),
(3, 3, 'Quisiera visitar el museo.', '2025-03-19 11:00:00'),
(4, 4, '¿Estás disponible para un concierto?', '2025-03-19 12:00:00'),
(5, 5, '¡Cocinemos juntos!', '2025-03-19 13:00:00'),
(6, 6, '¿Me puedes ayudar con yoga?', '2025-03-19 14:00:00'),
(7, 7, 'Me gustaría discutir libros.', '2025-03-19 15:00:00'),
(8, 8, '¿Puedes enseñarme fotografía?', '2025-03-19 16:00:00'),
(9, 9, 'Quiero aprender a pintar.', '2025-03-19 17:00:00'),
(10, 10, '¿Podemos ir al teatro?', '2025-03-19 18:00:00');

INSERT INTO app_user (username, password, role) VALUES ('admin', 'admin123', 'ROLE_ADMIN');
INSERT INTO app_user (username, password, role) VALUES ('user', 'user123', 'ROLE_USER');
