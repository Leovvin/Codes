cmake_minimum_required(VERSION 3.6)
project(Vector)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp Vector.h Constructor_by_copying.h insert.cpp expand.cpp)
add_executable(Vector ${SOURCE_FILES})