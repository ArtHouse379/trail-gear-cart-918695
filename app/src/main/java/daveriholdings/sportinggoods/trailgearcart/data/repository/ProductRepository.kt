package daveriholdings.sportinggoods.trailgearcart.data.repository

import daveriholdings.sportinggoods.trailgearcart.data.model.Product
import daveriholdings.sportinggoods.trailgearcart.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products = listOf<Product>(
        Product(
            id = 1,
            title = "Camping Tent",
            description = "This two-person camping tent provides dependable shelter for weekend trips and festival stays. A waterproof fly and sealed floor help keep the sleeping area dry in changeable weather. Mesh panels improve airflow while keeping insects outside. The compact carry bag makes it easy to store with the rest of your camp kit.",
            category = ProductCategory.CAMPING,
            price = 129.99,
            imageUrl = "https://images.pexels.com/photos/2603681/pexels-photo-2603681.jpeg",
        ),
        Product(
            id = 2,
            title = "Sleeping Bag",
            description = "This three-season sleeping bag offers comfortable warmth for cool nights at camp. Its insulated hood and adjustable opening help retain heat without feeling restrictive. The durable outer fabric stands up to regular outdoor use. It compresses into a practical stuff sack for transport.",
            category = ProductCategory.CAMPING,
            price = 74.99,
            imageUrl = "https://images.pexels.com/photos/5994750/pexels-photo-5994750.jpeg",
        ),
        Product(
            id = 3,
            title = "Hiking Backpack",
            description = "This 35-litre hiking backpack carries food, layers, and trail essentials on full-day routes. A ventilated back panel and padded hip belt spread the load comfortably. Multiple pockets keep water bottles and small equipment within easy reach. The tough fabric is designed for frequent use on rugged paths.",
            category = ProductCategory.HIKING,
            price = 89.99,
            imageUrl = "https://images.pexels.com/photos/19285943/pexels-photo-19285943.jpeg",
        ),
        Product(
            id = 4,
            title = "Hiking Boots",
            description = "These waterproof hiking boots provide stable footing on rocky paths and muddy tracks. The cushioned midsole supports long walking days, while the grippy outsole improves traction. A reinforced toe protects against roots and loose stones. The padded collar offers a secure and comfortable fit.",
            category = ProductCategory.HIKING,
            price = 119.99,
            imageUrl = "https://images.pexels.com/photos/10433248/pexels-photo-10433248.jpeg",
        ),
        Product(
            id = 5,
            title = "Mountain Bike",
            description = "This aluminium mountain bike is built for forest tracks, bridleways, and everyday rides. Front suspension smooths out roots and rough ground, while wide tyres provide confident grip. A broad gear range helps on both steep climbs and fast descents. Responsive disc brakes deliver reliable control in varied conditions.",
            category = ProductCategory.CYCLING,
            price = 649.99,
            imageUrl = "https://images.pexels.com/photos/1010547/pexels-photo-1010547.jpeg",
        ),
        Product(
            id = 6,
            title = "Bicycle Helmet",
            description = "This lightweight bicycle helmet protects riders on commutes, road sessions, and trail outings. Adjustable rear fitting gives a secure feel across a useful range of head sizes. Generous vents keep air moving during harder efforts. The removable pads make regular cleaning simple.",
            category = ProductCategory.CYCLING,
            price = 54.99,
            imageUrl = "https://images.pexels.com/photos/5808007/pexels-photo-5808007.jpeg",
        ),
        Product(
            id = 7,
            title = "Adjustable Dumbbell",
            description = "This adjustable dumbbell replaces several fixed weights for efficient home strength training. Quick weight changes support varied exercises and progressive workouts. The textured handle gives a firm grip during presses, rows, and squats. Its compact design stores neatly when the session is over.",
            category = ProductCategory.FITNESS,
            price = 149.99,
            imageUrl = "https://images.pexels.com/photos/16513601/pexels-photo-16513601.jpeg",
        ),
        Product(
            id = 8,
            title = "Yoga Mat",
            description = "This cushioned yoga mat creates a supportive surface for stretching, mobility, and floor exercises. Its textured finish helps hands and feet stay steady through changing poses. The closed-cell material wipes clean after each workout. A light roll-up design makes it convenient to carry to class.",
            category = ProductCategory.FITNESS,
            price = 34.99,
            imageUrl = "https://images.pexels.com/photos/16143600/pexels-photo-16143600.jpeg",
        ),
        Product(
            id = 9,
            title = "Recreational Kayak",
            description = "This single-seat recreational kayak offers stable handling for calm lakes and slow rivers. A padded seat and adjustable footrests keep longer paddles comfortable. The open storage area holds a dry bag and essential safety equipment. Durable construction makes it a dependable choice for regular summer outings.",
            category = ProductCategory.WATER_SPORTS,
            price = 449.99,
            imageUrl = "https://images.pexels.com/photos/2771470/pexels-photo-2771470.jpeg",
        ),
        Product(
            id = 10,
            title = "Paddleboard",
            description = "This inflatable paddleboard gives beginners a stable platform for exploring sheltered water. A non-slip deck pad improves balance and comfort underfoot. The package includes an adjustable paddle, pump, fin, leash, and carry bag. Once deflated, the board packs down neatly for transport and storage.",
            category = ProductCategory.WATER_SPORTS,
            price = 329.99,
            imageUrl = "https://images.pexels.com/photos/34633994/pexels-photo-34633994.jpeg",
        ),
    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}
