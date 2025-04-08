INSERT INTO categories (name) 
VALUES 
('Starters'),
('Burgers'),
('Sides'),
('Menu'),
('Drinks'),
('Desserts');

-- Insertar todos los productos en un solo comando INSERT
INSERT INTO products (name, description, price, availability, image_url, category_id1)
VALUES 
-- Starters (category_id = 1)
('RAMchos', 'Crispy corn nachos topped with melted cheese, homemade guacamole, pico de gallo, jalapeños, sour cream, and chili con carne.', 9.75, 1, '../images/ramchos.jpg', 1),
('CPU Sticks', 'Breaded chicken breast strips with a mix of "Programmed Spices", served with honey mustard sauce.', 8.25, 1, '../images/cpu-sticks.jpg', 1),
('Cheesobyte', 'Delicious cheese sticks wrapped in a crispy golden crust.', 7.50, 1, '../images/cheesobyte.jpg', 1),

-- Burgers (category_id = 2)
('The Motherboard', 'Juicy 180g beef patty, fresh lettuce, tomato, red onion, pickles, and our "Operating System" sauce on brioche bun.', 9.50, 1, '../images/motherboard-burger.jpg', 2),
('Crunchy Firewall', '200g beef patty, crispy bacon, melted cheddar, breaded onion rings, BBQ "Source Code" sauce, and chipotle mayo on rustic bun.', 12.95, 1, '../images/firewall-burger.jpg', 2),
('The Python', 'Chicken burger marinated in herbs, goat cheese, arugula, sun-dried tomatoes, caramelized onion, and aioli on olive bread.', 11.75, 1, '../images/python-burger.jpg', 2),
('Binary Veggie 01', 'Vegetarian burger made with chickpeas and beetroot, avocado, mixed greens, tomato, vegan cheese, and beetroot hummus on whole-grain bun.', 10.95, 1, '../images/binary-veggie-burger.jpg', 2),
('Double Core Processor', 'Double beef patties (360g), triple cheese (cheddar, gouda, provolone), grilled onion, pickles, and "Cache" sauce on brioche bun.', 14.50, 1, '../images/double-core-burger.jpg', 2),
('Java HotSpot', 'Spiced beef patty, jalapeños, fresh guacamole, pepper jack cheese, pico de gallo, lettuce, and sour cream on corn bun.', 12.50, 1, '../images/java-hotspot-burger.jpg', 2),
('The Gourmet Algorithm', '200g Black Angus beef patty, sautéed mushrooms, brie cheese, arugula, caramelized onions, and truffle mayo on rustic bun.', 14.95, 1, '../images/algoritmo-burger.jpg', 2),
('RGB Blue Cheese', '180g beef patty, blue cheese, bacon jam, arugula, caramelized walnuts, and mustard-honey mayo on seeded bun.', 13.50, 1, '../images/rgb-blue-burger.jpg', 2),
('The Kernel Crunch', 'Crispy chicken breast, homemade coleslaw, pickles, "Honey Mustard Server" sauce, and cheddar cheese on brioche bun.', 11.95, 1, '../images/kernel-crunch-burger.jpg', 2),
('The Stack Overflow', 'Triple beef patties (540g), fried egg, bacon, cheddar cheese, onion rings, pickles, lettuce, tomato, and "Root Access" sauce on XXL bun.', 18.95, 1, '../images/stack-overflow-burger.jpg', 2),

-- Sides (category_id = 3)
('USB Rings', 'Onion rings battered in crispy tempura, served with BBQ sauce and ranch dressing "Compatible with All Systems".', 6.50, 1, '../images/usb-rings.jpg', 3),
('Fry Bytes', 'Classic french fries, perfectly seasoned with the ideal balance of crispiness outside and softness inside. An unbeatable side!', 5.50, 1, '../images/fry-bytes.jpg', 3),
('Wedge Debug', 'Potato wedges with golden skins and a touch of spices. A slightly different, flavor-packed option.', 5.50, 1, '../images/wedge-debug.jpg', 3),

-- Menú (category_id = 4)
('Menu Debug Delight', 'La Motherboard + Fry Bytes + Strawberry Debug Smoothie', 17.95, 1, '../images/menu-debug-delight.jpg', 4),
('Firewall Feast', 'Firewall Crujiente + USB Rings + Brownie Overflow', 23.95, 1, '../images/firewall-feast.jpg', 4),
('Binary Veggie Pack', 'Binary Veggie 01 + Wedge Debug + Binary Brownie Shake', 19.95, 1, '../images/binary-veggie-pack.jpg', 4),
('Kernel Gourmet Menu', 'La Kernel Crunch + Fry Bytes + Cookie Cache', 21.95, 1, '../images/kernel-gourmet-menu.jpg', 4),

-- Drinks (category_id = 5)
('Water', 'Natural mineral water, refreshing and pure.', 1.50, 1, '../images/water.jpg', 5),
('Coca-Cola', 'Classic soda with the unmistakable Coca-Cola flavor.', 2.00, 1, '../images/coca-cola.jpg', 5),
('Nestea', 'Iced tea drink with a hint of lemon.', 2.00, 1, '../images/nestea.jpg', 5),
('Fanta Orange', 'Soda with bubbles and a refreshing orange flavor.', 2.00, 1, '../images/fanta-orange.jpg', 5),
('Fanta Lemon', 'Soda with bubbles and a zesty lemon flavor.', 2.00, 1, '../images/fanta-lemon.jpg', 5),
('Beer', 'Cold and frothy beer, perfect to pair with your meals.', 2.50, 1, '../images/beer.jpg', 5),

-- Desserts (category_id = 6)
('Cookie Cache', 'Creamy cheesecake with an Oreo cookie base, vanilla cream topping, and chocolate "Bits" sprinkles.', 6.50, 1, '../images/cookie-cache-dessert.jpg', 5),
('Brownie Overflow', 'Homemade chocolate brownie served warm with vanilla ice cream, "Digital Ink" chocolate sauce, whipped cream, and caramelized walnuts.', 7.25, 1, '../images/brownie-overflow-dessert.jpg', 5),
('Strawberry Debug Smoothie', 'A perfect blend of fresh strawberries, cream cheese, Greek yogurt, and milk. Finished with whipped cream and cookie crumbs to remove any "bugs" in your day.', 5.50, 1, '../images/Strawberry-Debug-Smoothie.jpg', 5),
('Binary Brownie Shake', 'A mix of brownie chunks, chocolate ice cream, and a hint of coffee in a "bit"-perfect dessert. Decorated with whipped cream and brownie bits for a complete finish.', 6.00, 1, '../images/Binary-Brownie-Shake.jpg', 5);

INSERT INTO allergens (name, description) VALUES
('Gluten', 'Found in bread for burgers, tempura coatings (e.g., USB Rings), and some desserts.'),
('Lactose', 'Present in cheese, sauces (e.g., truffle mayo), and most desserts like "Cookie Cache" or milkshakes.'),
('Nuts', 'Included in recipes like "RGB Blue Cheese" with caramelized walnuts and certain desserts.'),
('Egg', 'Used in mayonnaise, brioche buns, and some desserts like brownies.'),
('Soy', 'Potentially present in processed items such as sauces or bread.'),
('Fish', 'Not directly used in dishes but may appear due to cross-contamination risks.'),
('Shellfish', 'Not included in the menu but should be declared if cross-contamination occurs.'),
('Mustard', 'Found in sauces like "Honey Mustard Server" and other condiments.'),
('Sesame', 'May be present in seeded buns used in some burgers.'),
('Peanuts', 'Not included in the menu but cross-contamination is a possibility.'),
('Celery', 'Found in certain base ingredients like broths or sauces.');

INSERT INTO products_allergens (allergen_id1, product_id1) VALUES
-- RAMchos
(1, 1), -- Gluten (nachos)
(2, 1), -- Lactose (queso, crema agria)

-- CPU Sticks
(1, 2), -- Gluten (empanizado)
(4, 2), -- Egg (empanizado)
(8, 2), -- Mustard (salsa de mostaza y miel)

-- Cheesobyte
(1, 3), -- Gluten (cubierta crujiente)
(2, 3), -- Lactose (queso)
(4, 3), -- Egg (posible en empanizado)

-- The Motherboard
(1, 4), -- Gluten (pan brioche)
(2, 4), -- Lactose (posible en salsas)
(4, 4), -- Egg (posible en pan brioche y salsas)

-- Crunchy Firewall
(1, 5), -- Gluten (pan rústico, aros de cebolla empanizados)
(2, 5), -- Lactose (queso cheddar)
(4, 5), -- Egg (posible en mayonesa chipotle)

-- The Python
(1, 6), -- Gluten (pan de oliva)
(2, 6), -- Lactose (queso de cabra) 
(4, 6), -- Egg (aioli)

-- Binary Veggie 01
(1, 7), -- Gluten (pan integral)
(2, 7), -- Lactose (queso vegano)
(9, 7), -- Sesame (posible en pan integral)

-- Double Core Processor
(1, 8), -- Gluten (pan brioche)
(2, 8), -- Lactose (triple queso)
(4, 8), -- Egg (posible en pan brioche y salsas)

-- Java HotSpot
(1, 9), -- Gluten (pan de maíz)
(2, 9), -- Lactose (queso pepper jack, crema agria)
(4, 9), -- Egg (posible en salsas)

-- The Gourmet Algorithm
(1, 10), -- Gluten (pan rústico)
(2, 10), -- Lactose (queso brie)
(3, 10), -- Nuts (posible en salsas o ingredientes gourmet)
(4, 10), -- Egg (mayo de trufa)

-- RGB Blue Cheese
(1, 11), -- Gluten (pan con semillas)
(2, 11), -- Lactose (queso azul)
(3, 11), -- Nuts (nueces caramelizadas)
(4, 11), -- Egg (mayonesa de mostaza y miel)
(8, 11), -- Mustard (mayonesa de mostaza y miel)
(9, 11), -- Sesame (pan con semillas)

-- The Kernel Crunch
(1, 12), -- Gluten (pan brioche, empanizado de pollo)
(2, 12), -- Lactose (queso cheddar, coleslaw)
(4, 12), -- Egg (empanizado, mayonesa)
(8, 12), -- Mustard (salsa "Honey Mustard Server")

-- The Stack Overflow
(1, 13), -- Gluten (pan XXL)
(2, 13), -- Lactose (queso cheddar)
(4, 13), -- Egg (huevo frito, posible en salsas)

-- USB Rings
(1, 14), -- Gluten (tempura)
(4, 14), -- Egg (posible en tempura y ranch)
(2, 14), -- Lactose (aderezo ranch)

-- Fry Bytes
(1, 15), -- Gluten (posible contaminación cruzada)

-- Wedge Debug
(1, 16), -- Gluten (posible contaminación cruzada)

-- Menu Debug Delight (incluye Motherboard + Fry Bytes + Smoothie)
(1, 17), -- Gluten
(2, 17), -- Lactose
(4, 17), -- Egg

-- Firewall Feast (incluye Firewall + USB Rings + Brownie)
(1, 18), -- Gluten
(2, 18), -- Lactose
(3, 18), -- Nuts (en brownie)
(4, 18), -- Egg

-- Binary Veggie Pack (incluye Binary Veggie + Wedge + Brownie Shake)
(1, 19), -- Gluten
(2, 19), -- Lactose
(9, 19), -- Sesame

-- Kernel Gourmet Menu (incluye Kernel Crunch + Fry Bytes + Cookie Cache)
(1, 20), -- Gluten
(2, 20), -- Lactose
(4, 20), -- Egg
(8, 20), -- Mustard

-- Desserts
-- Cookie Cache
(1, 27), -- Gluten (base de galleta)
(2, 27), -- Lactose (queso crema, crema)

-- Brownie Overflow
(1, 28), -- Gluten (brownie)
(2, 28), -- Lactose (helado, crema)
(3, 28), -- Nuts (nueces caramelizadas)
(4, 28), -- Egg (en brownie)

-- Strawberry Debug Smoothie
(2, 29), -- Lactose (queso crema, yogur, leche, crema)
(1, 29), -- Gluten (migas de galleta)

-- Binary Brownie Shake
(1, 30), -- Gluten (trozos de brownie)
(2, 30), -- Lactose (helado de chocolate, crema)
(4, 30), -- Egg (en brownie)
(3, 30); -- Nuts (posible en brownie)

INSERT INTO clients (first_name, last_name, email, telephone, address, password_hash, created_at) VALUES
('Alice', 'Johnson', 'alice.johnson@example.com', '1234567890', '123 Main St, Springfield', '5f4dcc3b5aa765d61d8327deb882cf99', CURRENT_TIMESTAMP),
('Bob', 'Smith', 'bob.smith@example.com', '0987654321', '456 Elm St, Greenfield', 'e99a18c428cb38d5f260853678922e03', CURRENT_TIMESTAMP),
('Charlie', 'Brown', 'charlie.brown@example.com', '1112223333', '789 Oak St, Centerville', '202cb962ac59075b964b07152d234b70', CURRENT_TIMESTAMP),
('Diana', 'Prince', 'diana.prince@example.com', '4445556666', '321 Pine St, Gotham', 'c4ca4238a0b923820dcc509a6f75849b', CURRENT_TIMESTAMP),
('Edward', 'Norton', 'edward.norton@example.com', '7778889999', '654 Maple St, Metropolis', '098f6bcd4621d373cade4e832627b4f6', CURRENT_TIMESTAMP),
('Fiona', 'Green', 'fiona.green@example.com', '2223334444', '987 Cedar St, Star City', 'd41d8cd98f00b204e9800998ecf8427e', CURRENT_TIMESTAMP);

INSERT INTO establishments (name, address, telephone, opening_hours) VALUES
('Lingo Burguer Silicon Valley', '123 Silicon Valley Blvd, San Jose, CA', '408-555-1234', 'Mon-Sun: 9AM - 10PM'),
('Lingo Burguer Los Angeles', '456 Innovation St, Los Angeles, CA', '323-555-5678', 'Mon-Fri: 8AM - 8PM, Sat-Sun: 9AM - 6PM'),
('Lingo Burguer San Francisco', '789 Golden Gate Ave, San Francisco, CA', '415-555-7890', 'Mon-Sun: 10AM - 9PM');

INSERT INTO jobs (job_title, min_salary, max_salary) VALUES
('Cook', 1800.00, 2500.00),
('Cashier', 1600.00, 2200.00),
('Web Applications Developer', 2200.00, 3500.00),
('Manager', 2500.00, 4000.00),
('Cleaner', 1400.00, 1800.00);

-- Employees for "Lingo Burger Silicon Valley"
INSERT INTO employees (first_name, last_name, email, telephone, address, password_hash, hire_date, salary, job_id1, establishment_id1) VALUES
('Andrew', 'Miller', 'andrew.miller.siliconvalley@lingoburger.com', '408-555-1231', '101 Silicon Valley Blvd, San Jose, CA', '5f4dcc3b5aa765d61d8327deb882cf99', '2025-01-10', 2200.00, 1, 1), -- Cook
('Beatrice', 'Carter', 'beatrice.carter.siliconvalley@lingoburger.com', '408-555-2232', '102 Silicon Valley Blvd, San Jose, CA', 'e99a18c428cb38d5f260853678922e03', '2025-02-15', 2200.00, 1, 1), -- Cook
('Caleb', 'Wilson', 'caleb.wilson.siliconvalley@lingoburger.com', '408-555-3333', '103 Silicon Valley Blvd, San Jose, CA', '202cb962ac59075b964b07152d234b70', '2025-03-20', 2000.00, 2, 1), -- Cashier
('Deborah', 'Thomas', 'deborah.thomas.siliconvalley@lingoburger.com', '408-555-4444', '104 Silicon Valley Blvd, San Jose, CA', 'c4ca4238a0b923820dcc509a6f75849b', '2025-04-05', 2000.00, 2, 1), -- Cashier
('Ethan', 'Hill', 'ethan.hill.siliconvalley@lingoburger.com', '408-555-5555', '105 Silicon Valley Blvd, San Jose, CA', '098f6bcd4621d373cade4e832627b4f6', '2025-01-25', 3500.00, 3, 1), -- Web APP Developer
('Faith', 'Scott', 'faith.scott.siliconvalley@lingoburger.com', '408-555-6666', '106 Silicon Valley Blvd, San Jose, CA', 'd41d8cd98f00b204e9800998ecf8427e', '2025-03-01', 4000.00, 4, 1), -- Manager
('Grace', 'Taylor', 'grace.taylor.siliconvalley@lingoburger.com', '408-555-9090', '107 Silicon Valley Blvd, San Jose, CA', 'e99a18c428cb38d5f260853678922e03', '2025-02-15', 1800.00, 5, 1), -- Cleaner
('Henry', 'Martin', 'henry.martin.siliconvalley@lingoburger.com', '408-555-9191', '108 Silicon Valley Blvd, San Jose, CA', '202cb962ac59075b964b07152d234b70', '2025-03-20', 1800.00, 5, 1), -- Cleaner

-- Employees for "Lingo Burguer Los Angeles"
('Gavin', 'Walker', 'gavin.walker.losangeles@lingoburger.com', '323-555-1231', '201 Innovation St, Los Angeles, CA', '202cb962ac59075b964b07152d234b70', '2025-01-15', 2200.00, 1, 2), -- Cook
('Hannah', 'Clark', 'hannah.clark.losangeles@lingoburger.com', '323-555-2232', '202 Innovation St, Los Angeles, CA', '098f6bcd4621d373cade4e832627b4f6', '2025-03-05', 2200.00, 1, 2), -- Cook
('Isla', 'Peterson', 'isla.peterson.losangeles@lingoburger.com', '323-555-3333', '203 Innovation St, Los Angeles, CA', 'c4ca4238a0b923820dcc509a6f75849b', '2025-02-20', 2000.00, 2, 2), -- Cashier
('Jack', 'Ramirez', 'jack.ramirez.losangeles@lingoburger.com', '323-555-4444', '204 Innovation St, Los Angeles, CA', 'd41d8cd98f00b204e9800998ecf8427e', '2025-03-10', 2000.00, 2, 2), -- Cashier
('Kara', 'Fox', 'kara.fox.losangeles@lingoburger.com', '323-555-5555', '205 Innovation St, Los Angeles, CA', '5f4dcc3b5aa765d61d8327deb882cf99', '2025-04-01', 3500.00, 3, 2), -- Web APP Developer
('Luke', 'Gray', 'luke.gray.losangeles@lingoburger.com', '323-555-6666', '206 Innovation St, Los Angeles, CA', 'e99a18c428cb38d5f260853678922e03', '2025-01-10', 4000.00, 4, 2), -- Manager
('Isabel', 'Stewart', 'isabel.stewart.losangeles@lingoburger.com', '323-555-9090', '207 Innovation St, Los Angeles, CA', 'd41d8cd98f00b204e9800998ecf8427e', '2025-01-15', 1800.00, 5, 2), -- Cleaner
('Jack', 'Anderson', 'jack.anderson.losangeles@lingoburger.com', '323-555-9191', '208 Innovation St, Los Angeles, CA', '5f4dcc3b5aa765d61d8327deb882cf99', '2025-02-10', 1800.00, 5, 2), -- Cleaner

-- Employees for "Lingo Burguer San Francisco"
('Madison', 'Reed', 'madison.reed.sanfrancisco@lingoburger.com', '415-555-1231', '301 Golden Gate Ave, San Francisco, CA', 'e99a18c428cb38d5f260853678922e03', '2025-01-20', 2200.00, 1, 3), -- Cook
('Nathan', 'Cole', 'nathan.cole.sanfrancisco@lingoburger.com', '415-555-2232', '302 Golden Gate Ave, San Francisco, CA', '5f4dcc3b5aa765d61d8327deb882cf99', '2025-03-05', 2200.00, 1, 3), -- Cook
('Olivia', 'Harper', 'olivia.harper.sanfrancisco@lingoburger.com', '415-555-3333', '303 Golden Gate Ave, San Francisco, CA', 'c4ca4238a0b923820dcc509a6f75849b', '2025-02-25', 2000.00, 2, 3), -- Cashier
('Paul', 'Murray', 'paul.murray.sanfrancisco@lingoburger.com', '415-555-4444', '304 Golden Gate Ave, San Francisco, CA', 'd41d8cd98f00b204e9800998ecf8427e', '2025-04-15', 2000.00, 2, 3), -- Cashier
('Rose', 'Williams', 'rose.williams.sanfrancisco@lingoburger.com', '415-555-6666', '306 Golden Gate Ave, San Francisco, CA', '098f6bcd4621d373cade4e832627b4f6', '2025-03-01', 4000.00, 4, 3), -- Manager
('Kate', 'Robinson', 'kate.robinson.sanfrancisco@lingoburger.com', '415-555-9090', '307 Golden Gate Ave, San Francisco, CA', 'e99a18c428cb38d5f260853678922e03', '2025-03-05', 1800.00, 5, 3), -- Cleaner
('Leo', 'Murphy', 'leo.murphy.sanfrancisco@lingoburger.com', '415-555-9191', '308 Golden Gate Ave, San Francisco, CA', '098f6bcd4621d373cade4e832627b4f6', '2025-04-15', 1800.00, 5, 3); -- Cleaner

INSERT INTO payment_methods (name_method)
VALUES
('Cash'),
('Credit Card');

INSERT INTO job_offers (title, description, min_salary, max_salary, status, publication_date, end_date, journal, experience_required, education_required, establishment_id3) VALUES
('Web Applications Developer', 'Looking for a skilled Web Applications Developer to join our team at Lingo Burger San Francisco. Responsibilities include designing, developing, and maintaining web applications. Candidates should have proficiency in modern web development frameworks and tools.', 
2200.00, 3500.00, 1, '2025-04-10', '2025-05-10', 'full', '2+ years of experience in web development', 'Higher Degree in Web Applications Development', 3);


