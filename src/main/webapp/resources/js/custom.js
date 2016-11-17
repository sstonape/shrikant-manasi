$(document).on("ready",function(){  
    _initSlider();
    _showCount();
});
/**
 * Use to init slider 
 */
var _initSlider = function(){
  $('.heroSlider').vegas({
      overlay: true,
      transition: 'blur', 
      transitionDuration: 4000,
      delay: 10000,
      color: 'red',
      animation: 'random',
      animationDuration: 20000,
      slides: [
        { src: 'images/slide1.jpg' },
        { src: 'images/slide2.jpg' },
        { src: 'images/slide3.jpg' },
        { src: 'images/slide4.jpg' }
      ]
    });
};
/**
 * Use to show countdown timeer
 */
var  _showCount = function(){
    var deadline = '2016/12/03';
    $(".remTime")
      .countdown(deadline, function(event) {
        $(this).find(".week").html(event.strftime('%W'));
        $(this).find(".days").html(event.strftime('%D'));
        $(this).find(".hr").html(event.strftime('%H'));
        $(this).find(".min").html(event.strftime('%M'));
        $(this).find(".sec").html(event.strftime('%S'));       
    });   
}
