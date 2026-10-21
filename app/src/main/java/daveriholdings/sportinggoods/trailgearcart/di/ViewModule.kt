package daveriholdings.sportinggoods.trailgearcart.di

import daveriholdings.sportinggoods.trailgearcart.ui.viewmodel.AppViewModel
import daveriholdings.sportinggoods.trailgearcart.ui.viewmodel.CartViewModel
import daveriholdings.sportinggoods.trailgearcart.ui.viewmodel.CheckoutViewModel
import daveriholdings.sportinggoods.trailgearcart.ui.viewmodel.OnboardingViewModel
import daveriholdings.sportinggoods.trailgearcart.ui.viewmodel.OrderViewModel
import daveriholdings.sportinggoods.trailgearcart.ui.viewmodel.ProductDetailsViewModel
import daveriholdings.sportinggoods.trailgearcart.ui.viewmodel.ProductViewModel
import daveriholdings.sportinggoods.trailgearcart.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}