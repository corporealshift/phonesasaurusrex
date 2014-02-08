$ ->
    renderer = new PIXI.WebGLRenderer 700, 400

    $('.wrapper').append renderer.view

    stage = new PIXI.Stage