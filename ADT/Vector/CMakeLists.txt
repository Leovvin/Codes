cmake_minimum_required(VERSION 3.6)
project(Vector)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++14")

set(SOURCE_FILES Vector.h Constructor_by_copying.h insert.h expand.h main.cpp removeinterval.h shrink.h traverse.h)
add_executable(Vector ${SOURCE_FILES})