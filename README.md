# Source Code Demo-Movie Box

# Architecture : MVVM.

- split abstract into base module for reuse and clear code

- Dependency injection: Koin for reusability of classes and decoupling

- Using Rxjava2 + Retrofit to fetch data

- Using DiffUtil.Callback to calculate changed items to reduce notify the whole list

- Using Glide to load image and auto cache image.

- Using Pagging2 for pagination purpose

- Please open images folder to see the result.

# More Detail

- split small viewModel to reuse later such as PlayingNowViewModel, MostPopularViewModel

- implement more function: retry when loading most popular movie error

- developed in portrait mode only

# Test

- mockito for Unit Test

- Koin test library for mock and test UI test with mocked response data

# Thank you for reading.